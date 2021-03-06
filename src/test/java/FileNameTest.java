package test.java;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import main.java.net.monolith.Language;
import main.java.net.monolith.LanguageFactory;
import main.java.net.monolith.MonolithFrame;

public class FileNameTest {
	
	public static void main(String args[]){

		
		LanguageFactory.generateLanguages();
		List<MonolithFrame> frames = new ArrayList<MonolithFrame>();
		File dir = new File("tempFolder");

		if(dir.exists()){
			String[]entries = dir.list();
			for(String s: entries){
			    File currentFile = new File(dir.getPath(),s);
			    currentFile.delete();
			}
			dir.delete();
		}
		
		dir.mkdir();
		
		for (Language l : LanguageFactory.languages) {
			MonolithFrame mf = new MonolithFrame(null, null);
			mf.setLanguage(l);
			mf.setText("Hello");
			mf.fullName = mf.suggetFileName();
			mf.path = dir.getAbsolutePath() + "/";
			mf.saveFile(false);
			frames.add(mf);
		} 
		
		for(MonolithFrame mf: frames){
			mf.exitFile();
		}
	}

}
