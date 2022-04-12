package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Log
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;

    private static final String MAIL_TO = "pablo.kapp@dbccompany.com.br";

    @Value("${spring.mail.username}")
    private String from;
    private final JavaMailSender emailSender;

    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(MAIL_TO);
        message.setSubject("TESTE");
        message.setText("Teste\n minha mensagem \n\nAtt,\nEu.");
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

    public void sendEmail() {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(MAIL_TO);
            mimeMessageHelper.setSubject("TESTE");
            mimeMessageHelper.setText(geContentFromTemplate(), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }



    public void sendEmail(PessoaDTO pessoaDTO, String mensagem){
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try{
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaDTO.getEmail());
            mimeMessageHelper.setSubject("Primeiro email para pessoa");
            mimeMessageHelper.setText(sendEmailService(pessoaDTO, mensagem), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        }catch (MessagingException | IOException | TemplateException e){
            e.printStackTrace();
        }
    }

    public String geContentFromTemplate() throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", "MeuNome");
        Template template = fmConfiguration.getTemplate("email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }
//    public String pessoaNovaTemplate(PessoaDTO pessoaDTO, String metodo) throws IOException, TemplateException{
//        Map<String, Object> dados = new HashMap<>();
//        dados.put("nome", pessoaDTO.getNome());
//        dados.put("id", pessoaDTO.getIdPessoa());
//        String mensagem = "";
//        if(metodo == "create"){
//            mensagem = "Estamos felizes em ter você em nosso sistema \n " +
//                    "Seu cadastro foi realizado com sucesso)";
//        }else if(metodo == "update"){
//            mensagem = "aa";
//        }else if(metodo == "delete"){
//            mensagem = "Você perdeu o acesso ao nosso sistema.";
//        }
//
//        dados.put("mensagem", mensagem);
//        dados.put("suporteEmail", from);
//        Template template = fmConfiguration.getTemplate("email-template.ftl");
//        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
//        return html;
//    }

    public String sendEmailService(PessoaDTO pessoaDTO, String mensagem) throws IOException, TemplateException{
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaDTO.getNome());
        dados.put("id", pessoaDTO.getIdPessoa());
        dados.put("mensagem", mensagem);
        dados.put("suporteEmail", from);
        log.info("sendEmailService EmailService");
        System.out.println(dados);
        Template template = fmConfiguration.getTemplate("email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }






}
