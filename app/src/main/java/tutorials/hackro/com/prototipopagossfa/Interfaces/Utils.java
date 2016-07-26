package tutorials.hackro.com.prototipopagossfa.Interfaces;

import org.apache.commons.codec.DecoderException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import tutorials.hackro.com.prototipopagossfa.Models.EntidadPagoLinea;

/**
 * Created by david on 26/07/16.
 */
public interface Utils {

    public String construirCadena(EntidadPagoLinea pagoLinea);
    String encryptString(String cadena) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, BadPaddingException, IllegalBlockSizeException, DecoderException;

}
