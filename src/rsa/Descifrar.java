/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

/**
 *
 * @author bocal
 */
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.*;
import java.util.ArrayList;
import java.util.Random;
public class Descifrar {
    
    
    public String descifrar(ArrayList<BigInteger> lista, BigInteger[] cifrado) throws IOException{
        
        BigInteger p,q,n,phi,e,d;
        
        p=lista.get(0);
        q=lista.get(1);
        n=lista.get(2);
        e=lista.get(3);
        
        System.out.println("p: "+p);
        System.out.println("q: "+q);
        System.out.println("n: "+n);
            
        
        phi = p.subtract(BigInteger.valueOf(1));
        phi = phi.multiply(q.subtract(BigInteger.valueOf(1)));
        System.out.println("phi: "+phi);
        
        System.out.println(cifrado[0]+"---"+cifrado[1]);
        
        d=e.modInverse(phi);
        System.out.println("e: "+e);
        System.out.println("d: "+d);
        
        BigInteger[] descifrado = new BigInteger[cifrado.length];
        for (int i=0 ;i<descifrado.length ;i++ ) {
                descifrado[i]=cifrado[i].modPow(d,n);
        }
            
        char[] charArray = new char[descifrado.length];

        for (int i=0;i < charArray.length ; i++) {
                charArray[i]=(char)(descifrado[i].intValue());
        }
        System.out.println(new String(charArray));
        
        return (new String(charArray));
        
    }
    
}
