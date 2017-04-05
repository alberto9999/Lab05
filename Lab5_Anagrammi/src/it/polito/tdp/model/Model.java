package it.polito.tdp.model;

import java.util.*;

import it.polito.tdp.lab05.DAO.AnagrammaDAO;

public class Model {

	Set<String>listaAnagrammi;
	Set<String>listaAnagrammiCorretti;
	Set<String>listaAnagrammiErrati;
	
	public void risolvi(String parola){
		listaAnagrammi=new HashSet<String>();
		trovaParola(parola,0);
		verificaCorrettezza(listaAnagrammi);	
	}
	
	
	private void verificaCorrettezza(Set<String> listaAnagrammi) {
		listaAnagrammiCorretti=new HashSet<String>();
		listaAnagrammiErrati=new HashSet<String>();
		
		AnagrammaDAO aDAO =new AnagrammaDAO();
		
		for(String s: listaAnagrammi){
			if(aDAO.findParola(s)==true){
				listaAnagrammiCorretti.add(s);
			}
			else{
				listaAnagrammiErrati.add(s);
			}
				
		}
	}

	
	public String getAnagrammiCorretti(){
		String result="";
		for(String s: listaAnagrammiCorretti){
			result+=s+"\n";
		}
		return result;
	}
	
	public String getAnagrammiErrati(){
		String result="";
		for(String s: listaAnagrammiErrati){
			result+=s+"\n";
		}
		return result;
	}
	
	
	
	

	public void trovaParola(String parola,int livello) {
		char[]parolaChar=parola.toCharArray();		
		
		for(int i=livello;i<parola.length();i++){
		char temp=parolaChar[livello];
		parolaChar[livello]=parolaChar[i];
		parolaChar[i]=temp;
		 parola=new String(parolaChar);
		   //  if(!listaAnagrammi.contains(parola)){
			  listaAnagrammi.add(parola);		
		 //    }
		     if(livello<parola.length()-1){
		trovaParola(parola,livello+1);	}
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
