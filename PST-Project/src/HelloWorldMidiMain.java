
/*
 * c2017-2019 Courtney Brown 
 * 
 * Class: H
 * Description: Demonstration of MIDI file manipulations, etc. & 'MelodyPlayer' sequencer
 * 
 */

import processing.core.*;

import java.util.*; 

//importing the JMusic stuff
import jm.music.data.*;
import jm.JMC;
import jm.util.*;
import jm.midi.*;
//import themidibus.*;
import java.io.UnsupportedEncodingException;
import java.net.*;

//import javax.sound.midi.*;

			//make sure this class name matches your file name, if not fix.
public class HelloWorldMidiMain extends PApplet {

	MelodyPlayer player; //play a midi sequence
	MidiFileToNotes midiNotes; //read a midi file

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("HelloWorldMidiMain"); //change this to match above class & file name 

	}

	//setting the window size to 300x300
	public void settings() {
		size(700, 800);

	}

	//doing all the setup stuff
	public void setup() {
		fill(120, 50, 240);
		//GUI setup
		background(184, 201, 230);
		noStroke();
		//draw rectangles
		fill(212, 112, 142);
		rect(50,50,600,100);
		rect(50,225,600,100);
		rect(50,400,600,100);
		rect(50,575,600,100);
		//draw text 
		fill(0);
		textSize(20);
		text("Press 'a' to test ABRACADABRA.", 150, 100);
		text("Press 'b' to test ACADAACBDA.", 150, 275);
		text("Press 'c' to test ABCCCDAADCDAABCADAD.", 150, 450);
		text("Press 'd' to test Mary Had a Little Lamb.", 150, 625);
		
		// returns a url
		String filePath = getPath("mid/MaryHadALittleLamb.mid");
		// playMidiFile(filePath);

		midiNotes = new MidiFileToNotes(filePath); //creates a new MidiFileToNotes -- reminder -- ALL objects in Java must 
													//be created with "new". Note how every object is a pointer or reference. Every. single. one.


//		// which line to read in --> this object only reads one line (or ie, voice or ie, one instrument)'s worth of data from the file
		midiNotes.setWhichLine(0);

		player = new MelodyPlayer(this, 100.0f);

		player.setup();
		player.setMelody(midiNotes.getPitchArray());
		player.setRhythm(midiNotes.getRhythmArray());
		

	}

	public void draw() {
		//player.play(); //play each note in the sequence -- the player will determine whether is time for a note onset

	}

	//this finds the absolute path of a file
	String getPath(String path) {

		String filePath = "";
		try {
			filePath = URLDecoder.decode(getClass().getResource(path).getPath(), "UTF-8");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
	}

	//this function is not currently called. you may call this from setup() if you want to test
	//this just plays the midi file -- all of it via your software synth. You will not use this function in upcoming projects
	//but it could be a good debug tool.
	void playMidiFile(String filename) {
		Score theScore = new Score("Temporary score");
		Read.midi(theScore, filename);
		Play.midi(theScore);
	}

	//this starts & restarts the melody.
	public void keyPressed() {
		if (key == ' ') {
			player.reset();
			println("Melody started!");
		}
		if( key == 'a')
		{
			System.out.println("Abracadabra");
			Character[] myList = {'a', 'b', 'r', 'a', 'c', 'a', 'd', 'a', 'b', 'r', 'a'};
			ArrayList<Character> data = new ArrayList(Arrays.asList(myList));
			Tree<Character> tree = new Tree<Character>();
			tree.setL(3);
			tree.train(data);
			tree.printTree();	
		}
		if( key == 'b')
		{
			System.out.println("Acadaacbda");
			Character[] myList = {'a', 'c', 'a', 'd', 'a', 'a', 'c', 'b', 'd', 'a'};
			ArrayList<Character> data = new ArrayList(Arrays.asList(myList));
			Tree<Character> tree = new Tree<Character>();
			tree.setL(3);
			tree.train(data);
			tree.printTree();	
		}
		if( key == 'c')
		{
			System.out.println("Abcccdaadcdaabcadad");
			Character[] myList = {'a', 'b', 'c', 'c', 'c', 'd', 'a', 'a', 'd', 'c', 'd', 'a', 'a', 'b', 'c', 'a', 'd', 'a', 'd'};
			ArrayList<Character> data = new ArrayList(Arrays.asList(myList));
			Tree<Character> tree = new Tree<Character>();
			tree.setL(3);
			tree.train(data);
			tree.printTree();
		}
		if( key == 'd')
		{
			System.out.println("Mary Had a Little Lamb ");
			ArrayList<Integer> pitches = midiNotes.getPitchArray();
			Tree<Integer> tree = new Tree<Integer>();
			tree.setL(3);
			tree.train(pitches);
			tree.printTree();
		}
	}
}
