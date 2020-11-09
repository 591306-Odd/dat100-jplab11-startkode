package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		
		try {
			Scanner leser = new Scanner(new File(mappe + filnavn));
					
			int antall = Integer.parseInt(leser.nextLine());
			Blogg blogfratil = new Blogg(antall);
			
			for(int i = 0; i < antall; i++) {
				String type = leser.nextLine();
				
				int id = Integer.parseInt(leser.nextLine());
				String bruker = leser.nextLine();
				String dato = leser.nextLine();
				int likes = Integer.parseInt(leser.nextLine());
				String tekst = leser.nextLine();
								
				if(type.equals(TEKST)){
					
					Tekst t = new Tekst(id,bruker,dato,likes,tekst);
					blogfratil.leggTil(t);
					
				}else if(type.equals(BILDE)) {
					String url = leser.nextLine();
					Bilde t = new Bilde(id,bruker,dato,likes,tekst,url);
					blogfratil.leggTil(t);

				}
			
			}
			
			leser.close();
			return blogfratil;
			
		}
		catch(FileNotFoundException e){
			System.out.println("fil ikke funnet");
		}
		return null;
	}
}
