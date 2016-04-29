package br.estacio.siesau.control;

import java.util.ArrayList;
import java.util.List;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;


public class GoogleMap {
	
	public static List<Double> buscaCoordenadas(String endereco){
		
		List<Double> coordenadas = new ArrayList<>();
		
		try {
			
		
		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyAB4587fj1P5xJ6VSfeaGCgXugnJ-skaog");
		GeocodingResult[] results =  GeocodingApi.geocode(context,endereco).await();
				
		Double latitude = results[0].geometry.location.lat;
		System.out.println("Latitude :" + latitude);
		Double longetude = results[0].geometry.location.lng;
		System.out.println("Longetude: "+ longetude);
		coordenadas.add(latitude);
		coordenadas.add(longetude);
		
		
		String format = results[0].formattedAddress;
		System.out.println("Endereço formatado pelo Google: " + format);		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return coordenadas;
		
		
	}
	
	public static void main(String[] args) {
		
	GoogleMap.buscaCoordenadas("Rua Doutor Mário Guimaraes Nova Iguaçu ");	
		
	}
			

}
