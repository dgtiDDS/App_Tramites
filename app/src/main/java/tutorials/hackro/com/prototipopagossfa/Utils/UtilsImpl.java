package tutorials.hackro.com.prototipopagossfa.Utils;

import android.util.Log;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import tutorials.hackro.com.prototipopagossfa.Interfaces.Utils;
import tutorials.hackro.com.prototipopagossfa.Interfaces.dataGeneral;
import tutorials.hackro.com.prototipopagossfa.Models.EntidadPagoLinea;

/**
 * Created by david on 26/07/16.
 */
public class UtilsImpl implements Utils{



    dataGeneral data;

    @Override
    public String construirCadena(EntidadPagoLinea pagoLinea) {
        String respuesta = "";
        if (pagoLinea != null) {
            String numero = pagoLinea.getNumber().replaceAll(" ", "");
            pagoLinea.getId_company().trim();
            pagoLinea.getId_company().trim();
            pagoLinea.getId_branch().trim();
            pagoLinea.getCountry().trim();
            pagoLinea.getUser().trim();
            pagoLinea.getPwd();
            pagoLinea.getMerchant();
            pagoLinea.getReference();
            pagoLinea.getTp_operation();
            pagoLinea.getCrypto();
            pagoLinea.getExpmonth().trim();
            pagoLinea.getExpyear().trim();
            pagoLinea.getCvv_csc();
            pagoLinea.getAmount().trim();
            pagoLinea.getCurrency().trim();
            pagoLinea.getVersion().trim();
            respuesta = "<VMCAMEXM><business><id_company>" + pagoLinea.getId_company().trim() + "</id_company><id_branch>" + pagoLinea.getId_branch().trim() + "</id_branch><country>" + pagoLinea.getCountry().trim() + "</country><user>" + pagoLinea.getUser().trim() + "</user><pwd>" + pagoLinea.getPwd() + "</pwd></business><transacction><merchant>" + pagoLinea.getMerchant() + "</merchant><reference>" + pagoLinea.getReference() + "</reference><tp_operation>" + pagoLinea.getTp_operation() + "</tp_operation><creditcard><crypto>" + pagoLinea.getCrypto() + "</crypto><type>" + pagoLinea.getType() + "</type><name>" + pagoLinea.getName() + "</name><number>" + numero + "</number><expmonth>" + pagoLinea.getExpmonth().trim() + "</expmonth><expyear>" + pagoLinea.getExpyear().trim() + "</expyear><cvv-csc>" + pagoLinea.getCvv_csc() + "</cvv-csc></creditcard><amount>" + pagoLinea.getAmount().trim() + "</amount><currency>" + pagoLinea.getCurrency().trim() + "</currency><usrtransacction></usrtransacction><version>" + pagoLinea.getVersion().trim() + "</version></transacction></VMCAMEXM>".trim();


            try {
                return  "<pgs><data0>9265654613</data0><data>" + encryptString(respuesta) + "</data></pgs>";
            } catch (NoSuchPaddingException e) {
                respuesta = "";
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                respuesta = "";
                e.printStackTrace();
            } catch (InvalidKeyException e) {
                respuesta = "";
                e.printStackTrace();
            } catch (IOException e) {
                respuesta = "";
                e.printStackTrace();
            } catch (BadPaddingException e) {
                respuesta = "";
                e.printStackTrace();
            } catch (IllegalBlockSizeException e) {
                respuesta = "";
                e.printStackTrace();
            } catch (DecoderException e) {
                respuesta = "";
                e.printStackTrace();
            }

        }
        return respuesta.trim();
    }
    /**
     * Permite encriptar una cadena a partir de un llave proporcionada
     *
     * @return String con la cadena encriptada
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws IOException
     * @throws DecoderException
     */

    @Override
    public String encryptString(String cadena) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, BadPaddingException, IllegalBlockSizeException, DecoderException {
        byte[] raw = org.apache.commons.codec.binary.Hex.decodeHex(data.key.toCharArray());
        //Base64.decodeBase64(key.getBytes());
        //DatatypeConverter.parseHexBinary(key);

        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance(data.ALGORITMO);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

        byte[] cipherText = cipher.doFinal(cadena.getBytes(data.CODIFICACION));
        byte[] iv = cipher.getIV();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(iv);
        outputStream.write(cipherText);

        byte[] finalData = outputStream.toByteArray();

//Base64.decodeBase64(finalData)
        String encodedFinalData =
                android.util.Base64.encodeToString(finalData, 16);
        //org.apache.commons.codec.binary.Base64.encodeBase64String(finalData);
        //android.util.Base64.encodeToString(finalData, android.util.Base64.DEFAULT);
        //DatatypeConverter.printBase64Binary(finalData);

        return encodedFinalData;
    }





    /**
     * Permite desencriptar una cadena a partir de la llave proporcionada
     *
     * @param encodedInitialData
     * @param key
     * @return String de la cadena en claro
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidAlgorithmParameterException
     * @throws DecoderException
     */

    public String decrypt(String encodedInitialData, String key)
            throws InvalidKeyException, IllegalBlockSizeException,
            BadPaddingException, UnsupportedEncodingException,
            NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidAlgorithmParameterException, DecoderException {

        byte[] encryptedData = Base64.decodeBase64(encodedInitialData.getBytes());//org.apache.commons.codec.binary.Hex.decodeHex(encodedInitialData.toCharArray());
        //DatatypeConverter.parseBase64Binary(encodedInitialData);
        //key = //"A2832DE3C0B2289253D4B383404E8C1C"; //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        byte[] raw = org.apache.commons.codec.binary.Hex.decodeHex(key.toCharArray());
        //1DatatypeConverter.parseHexBinary(key);


        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance(data.ALGORITMO);

        byte[] iv = Arrays.copyOfRange(encryptedData, 0, 16);

        byte[] cipherText = Arrays.copyOfRange(encryptedData, 16,
                encryptedData.length);
        IvParameterSpec iv_specs = new IvParameterSpec(iv);

        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv_specs);

        byte[] plainTextBytes = cipher.doFinal(cipherText);
        String plainText = new String(plainTextBytes);

        return plainText;
    }

}
