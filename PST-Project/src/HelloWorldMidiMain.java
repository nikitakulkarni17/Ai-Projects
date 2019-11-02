
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
		text("Press 'a/b' to test ABRACADABRA. 1 for UT1", 100, 100);
		text("Press 'c/d' to test ACADAACBDA. 2 for UT1", 100, 275);
		text("Press 'e/f' to test ABCCCDAADCDAABCADAD. 3 for UT1", 100, 450);
		text("Press 'g/h' to test Mary Had a Little Lamb. 4 for UT1", 100, 625);
		
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
		//pst for 3 and .1 
		if( key == 'a')
		{
			System.out.println("Abracadabra: .1");
			Character[] myList = {'a', 'b', 'r', 'a', 'c', 'a', 'd', 'a', 'b', 'r', 'a'};
			ArrayList<Character> data = new ArrayList(Arrays.asList(myList));
			Tree<Character> tree = new Tree<Character>(3, 0.1f);
			tree.train(data);
			tree.printTree();	
		}
		//pst for 3 and .15
		if( key == 'b')
		{
			System.out.println("Abracadabra: .15");
			Character[] myList = {'a', 'b', 'r', 'a', 'c', 'a', 'd', 'a', 'b', 'r', 'a'};
			ArrayList<Character> data = new ArrayList(Arrays.asList(myList));
			Tree<Character> tree = new Tree<Character>(3, 0.15f);
			tree.train(data);
			tree.printTree();	
		}
		if( key == '1')
		{
			System.out.println("Abracadabra: Unit Test 1");
			Character[] myList = {'a', 'b', 'r', 'a', 'c', 'a', 'd', 'a', 'b', 'r', 'a'};
			ArrayList<Character> data = new ArrayList(Arrays.asList(myList));
			Tree<Character> tree = new Tree<Character>();
			tree.train(data);
			tree.printTree();	
		}
		//pst for 3 and .1 
		if( key == 'c')
		{
			System.out.println("Acadaacbda: .1");
			Character[] myList = {'a', 'c', 'a', 'd', 'a', 'a', 'c', 'b', 'd', 'a'};
			ArrayList<Character> data = new ArrayList(Arrays.asList(myList));
			Tree<Character> tree = new Tree<Character>(3, .1f);
			tree.train(data);
			tree.printTree();	
		}
		//pst for 3 and .15
		if( key == 'd')
		{
			System.out.println("Acadaacbda: .15");
			Character[] myList = {'a', 'c', 'a', 'd', 'a', 'a', 'c', 'b', 'd', 'a'};
			ArrayList<Character> data = new ArrayList(Arrays.asList(myList));
			Tree<Character> tree = new Tree<Character>(3, 0.15f);
			tree.train(data);
			tree.printTree();	
		}
		if( key == '2')
		{
			System.out.println("Acadaacbda: Unit Test 1");
			Character[] myList = {'a', 'c', 'a', 'd', 'a', 'a', 'c', 'b', 'd', 'a'};
			ArrayList<Character> data = new ArrayList(Arrays.asList(myList));
			Tree<Character> tree = new Tree<Character>();
			tree.train(data);
			tree.printTree();	
		}
		//pst for 3 and .1 
		if( key == 'e')
		{
			System.out.println("Abcccdaadcdaabcadad: .1");
			Character[] myList = {'a', 'b', 'c', 'c', 'c', 'd', 'a', 'a', 'd', 'c', 'd', 'a', 'a', 'b', 'c', 'a', 'd', 'a', 'd'};
			ArrayList<Character> data = new ArrayList(Arrays.asList(myList));
			Tree<Character> tree = new Tree<Character>(3, 0.1f);
			tree.train(data);
			tree.printTree();
		}
		//pst for 3 and .15
		if( key == 'f')
		{
			System.out.println("Abcccdaadcdaabcadad: .15");
			Character[] myList = {'a', 'b', 'c', 'c', 'c', 'd', 'a', 'a', 'd', 'c', 'd', 'a', 'a', 'b', 'c', 'a', 'd', 'a', 'd'};
			ArrayList<Character> data = new ArrayList(Arrays.asList(myList));
			Tree<Character> tree = new Tree<Character>(3, 0.15f);
			tree.train(data);
			tree.printTree();
		}
		if( key == '3')
		{
			System.out.println("Abcccdaadcdaabcadad: Unit Test 1");
			Character[] myList = {'a', 'b', 'c', 'c', 'c', 'd', 'a', 'a', 'd', 'c', 'd', 'a', 'a', 'b', 'c', 'a', 'd', 'a', 'd'};
			ArrayList<Character> data = new ArrayList(Arrays.asList(myList));
			Tree<Character> tree = new Tree<Character>();
			tree.train(data);
			tree.printTree();
		}
		if( key == 'g')
		{
			System.out.println("Mary Had a Little Lamb: .1");
			ArrayList<Integer> pitches = midiNotes.getPitchArray();
			Tree<Integer> tree = new Tree<Integer>(3, 0.1f);
			tree.train(pitches);
			tree.printTree();
		}
		if( key == 'h')
		{
			System.out.println("Mary Had a Little Lamb: .15");
			ArrayList<Integer> pitches = midiNotes.getPitchArray();
			Tree<Integer> tree = new Tree<Integer>(3, 0.15f);
			tree.train(pitches);
			tree.printTree();
		}
		if( key == '4')
		{
			System.out.println("Mary Had a Little Lamb: Unit Test 1");
			ArrayList<Integer> pitches = midiNotes.getPitchArray();
			Tree<Integer> tree = new Tree<Integer>();
			tree.train(pitches);
			tree.printTree();
		}
	}
}
