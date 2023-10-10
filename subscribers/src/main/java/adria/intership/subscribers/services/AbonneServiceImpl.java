package adria.intership.subscribers.services;

import adria.intership.subscribers.dto.AbonneDto;
import adria.intership.subscribers.entities.Abonne;
import adria.intership.subscribers.exceptions.AbonneNotFound;
import adria.intership.subscribers.mappers.AbonneMapper;
import adria.intership.subscribers.repositories.AbonneRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class AbonneServiceImpl implements AbonneService{

    private AbonneMapper abonneMapper;
    private AbonneRepository abonneRepository;
    private final JavaMailSender javaMailSender; // Injection

    @Override
    public AbonneDto saveAbonne(AbonneDto abonneDto) {
        Abonne abonne = abonneMapper.abonneDtoToAbonne(abonneDto);

        //génerer un username
        String username=generateUsername(abonneDto.getPrenom(),abonneDto.getNom());
        abonne.setNomUtilisateur(username);
        //génerer un token
        String verificationToken = generateVerificationToken();
        abonne.setToken(verificationToken);

        Abonne savedAbonne= abonneRepository.save(abonne);
        // Envoyer l'email de vérification
        sendVerificationEmail(savedAbonne.getEmail(), verificationToken);

        return abonneMapper.abonneToDto(savedAbonne);
    }

        //génerer le token de verificiation
        private String generateVerificationToken() {
            return UUID.randomUUID().toString();
        }

        //envoyer un email de verification lors de l'enregistrement de l'abonné
        private void sendVerificationEmail(String to, String verificationToken) {
            //un message MIME, un format couramment utilisé pour les emails
            MimeMessage message = javaMailSender.createMimeMessage();
            //configurer les détails de l'email
            MimeMessageHelper helper = new MimeMessageHelper(message);

            try {
                //configure l'adresse e-mail du destinataire
                helper.setTo(to);
                helper.setSubject("Vérification de l'adresse e-mail");
                helper.setText("Cliquez sur le lien suivant pour vérifier votre adresse e-mail : " +
                        "https://votre-site.com/verify-email/" + verificationToken, true);

                javaMailSender.send(message);
            } catch (MessagingException e) {
                // Gestion des exceptions
                e.printStackTrace();
            }
        }

        //génerer le nom utilisateur
        public String generateUsername(String firstName, String lastName) {
            // Supprimez les espaces en début et en fin de chaque nom
            firstName = firstName.trim();
            lastName = lastName.trim();

            // Convertit le prénom et le nom en minuscules
            firstName = firstName.toLowerCase();
            lastName = lastName.toLowerCase();

            // Supprimez les caractères spéciaux et les espaces
            firstName = firstName.replaceAll("[^a-zA-Z0-9]", "");
            lastName = lastName.replaceAll("[^a-zA-Z0-9]", "");

            String username;
            // Vérifiez si le prénom et le nom sont vides après nettoyage
            if (firstName.isEmpty() || lastName.isEmpty()) {
                username = firstName + "." + lastName;
            }else {

                // Prenez tout le prénom et les deux premières lettres du nom pour créer le nom d'utilisateur
                username = firstName + "." + lastName.substring(0, Math.min(2, lastName.length()));
            }
            return username;
        }

    @Override
    public AbonneDto getAbonne(Long id) throws AbonneNotFound {
        Abonne abonne=abonneRepository.findById(id).orElse(null);
        if(abonne==null)throw new AbonneNotFound("admin not found");
        return abonneMapper.abonneToDto(abonne);
    }

    @Override
    public AbonneDto updateAbonne(AbonneDto abonneDto) throws AbonneNotFound {
        Abonne existingAbonne= abonneRepository.findById(abonneDto.getId())
                .orElseThrow(() -> new AbonneNotFound("Admin not found"));

        existingAbonne.setNom(abonneDto.getNom());
        existingAbonne.setPrenom(abonneDto.getPrenom());
        existingAbonne.setEmail(abonneDto.getEmail());
        existingAbonne.setCIN(abonneDto.getCIN());
        existingAbonne.setAdresse(abonneDto.getAdresse());
        existingAbonne.setDateNaissance(abonneDto.getDateNaissance());
        existingAbonne.setSexe(abonneDto.getSexe());
        existingAbonne.setStatut(abonneDto.getStatut());

        abonneRepository.save(existingAbonne);

        return abonneMapper.abonneToDto(existingAbonne);
    }

    @Override
    public void deleteAbonne(Long id) {
        abonneRepository.deleteById(id);
    }

    @Override
    public List<AbonneDto> allAbonne() {
        List<Abonne> devises = abonneRepository.findAll();
        return devises.stream()
                .map(abonneMapper::abonneToDto)
                .collect(Collectors.toList());
    }

}
