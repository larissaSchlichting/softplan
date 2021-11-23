package com.softplan.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Validador {

    public static boolean isValidEmail(String email) throws Exception {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            throw new Exception("E-mail inválido! ", ex);
        }
        return result;
    }

    public static boolean isBornDateValid(String dataNascimento) throws ParseException {

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
            Date data1 = dateFormat.parse(dataNascimento);

            Date data = new Date();
            String dataAtual = dateFormat.format(data);
            Date dataAtualDate = dateFormat.parse(dataAtual);

            return dataAtualDate.before(data1);
        } catch (ParseException ex) {
            return false;
        }
    }

    public static boolean isValidCPF(String cpf) throws Exception {
        try {
            char dig10, dig11;
            int sm = 0;
            int peso = 10;
            int num, r;

            for (int i = 0; i < 9; i++) {

                num = (int)(cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48);

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(int i = 0; i < 10; i++) {
                num = (int)(cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);

            return ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)));

        } catch (Exception ex) {
            throw new Exception("CPF inválido.", ex);
        }
    }
}
