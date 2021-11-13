package dev.gio.empleos.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {
	
	public static String guardarArchivo(MultipartFile multiPart, String ruta) {
		String nombreOriginal = multiPart.getOriginalFilename();
		nombreOriginal = nombreOriginal.replace(" ", "_");
		String nombreFinal = randomAlphanumeric(8) + nombreOriginal;
		try {
			File imageFile = new File(ruta+nombreFinal);
			System.out.println("Archivo: "+imageFile.getAbsolutePath());
			multiPart.transferTo(imageFile);
			return nombreOriginal;
		}catch(IOException e){
			System.out.println("Error "+e.getMessage());
			return null;
		}
	}
	
	public static String randomAlphanumeric(int count) {
		String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXZ0123456789";
		StringBuilder builder = new StringBuilder();
		while(count-- != 0) {
			int caracter = (int) (Math.random() * CARACTERES.length());
			builder.append(CARACTERES.charAt(caracter));
		}
		return builder.toString();
	}
}
