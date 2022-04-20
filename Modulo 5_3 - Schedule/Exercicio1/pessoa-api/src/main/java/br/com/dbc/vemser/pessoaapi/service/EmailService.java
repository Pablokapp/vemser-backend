package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EmailDTO;
import br.com.dbc.vemser.pessoaapi.dto.pessoa.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;

    private static final String MAIL_TO = "pablokapp@gmail.com";

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(PessoaDTO pessoa) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(MAIL_TO);
        message.setTo(pessoa.getEmail());
        message.setSubject("Olá, " + pessoa.getNome() + ",");
        message.setText("Olá " + pessoa.getNome() + "\n\nEstamos muito felizes que você está em nosso sistema." +
                "\nPara que possamos enviá-los um brinde exclusivo, por gentileza, adicione ou atualize o seu endereço no seu cadastro." +
                "\nMuito obrigado,\nSistema de Pessoas");
        emailSender.send(message);
    }

    public void sendWithAttachment() throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message,
                true);

        helper.setFrom(from);
        helper.setTo(MAIL_TO);
        helper.setSubject("TESTE");
        helper.setText("Teste\n minha mensagem \n\nAtt,\nEu.");

        File file1 = new File("imagem.jpg");

        FileSystemResource file
                = new FileSystemResource(file1);
        helper.addAttachment(file1.getName(), file);

        emailSender.send(message);
    }

    public void sendEmail(PessoaDTO pessoaDTO, String assunto,String templateName) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaDTO.getEmail());
            mimeMessageHelper.setSubject(assunto);
            mimeMessageHelper.setText(geContentFromTemplate(pessoaDTO, templateName), true);
            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public String geContentFromTemplate(PessoaDTO pessoaDTO, String templateName) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaDTO.getNome());
        dados.put("id", pessoaDTO.getIdPessoa());
        dados.put("suporte_email", from);
        fmConfiguration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        Template template = fmConfiguration.getTemplate(templateName);
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public void sendSimpleMessageAniversariante(PessoaDTO pessoa, Integer idade) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(MAIL_TO);
        message.setTo(pessoa.getEmail());
        message.setSubject("Aniversariante");
        message.setText("Olá " + pessoa.getNome() +
                "\n\nEssa data de " + pessoa.getDataNascimento().getDayOfMonth() + "/" + pessoa.getDataNascimento().getMonthValue() +  " também é especial para nós do " +
                "Vem Ser. Estamos comemorando junto com você. " +
                "\nDesejamos um feliz aniversário, que sejam " + idade + " anos de muitos. Sucesso, alegria, " +
                "felicidade e muitas realizações." +
                "\n\nForte abraço,\n" +
                "VemSerDBC |!");
        emailSender.send(message);
    }


    public void sendSimpleMessageTodos(PessoaDTO pessoa) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(MAIL_TO);
        message.setTo(pessoa.getEmail());
        message.setSubject("Ofertas");
        message.setText("Ola " + pessoa.getNome() + "!\n\n" +
                "Selecionamos alguns dos nossos melhores produtos e criamos esta super promoção na nossa plataforma especialmente para você:\n" +
                "- Na compra de um CDs do Chitãozinho e Xororó, ganhe 1 do Milionário e José Rico." + "\n" +
                "- Na locação de um filme em VHS, a outra locação é grátis." + "\n" +
                "- Fita de Super Nintendo com 50% de desconto." + "\n\n" +
                "Aproveite,\n" +
                "Magazine OldSchool.");
        emailSender.send(message);
    }



    public void sendSimpleEmail(EmailDTO emailDTO) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(MAIL_TO);
        message.setTo(emailDTO.getDestinatario());
        message.setSubject(emailDTO.getAssunto());
        message.setText(emailDTO.getTexto());
        emailSender.send(message);
    }





}
