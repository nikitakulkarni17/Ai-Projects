
/*
 * c2017 Courtney Brown 
 * 
 * Class: MidiFileToNotes
 * Description: Uses JMusic to get notes & info from a midi file
 * 
 */

import java.util.*;
import jm.music.data.*;
import jm.util.*;

public class MidiFileToNotes {
	String filename;
	ArrayList<Integer> pitches;
	ArrayList<Double> rhythms;

	int whichLine;

	ArrayList<jm.music.data.Note> melody;

	MidiFileToNotes(String f) {
		filename = f;
		processPitchesAsTokens();
		whichLine = 0;
	}

	void setWhichLine(int line) {
		whichLine = line;
	}

	void processPitchesAsTokens() {
		pitches = new ArrayList<Integer>();
		melody = new ArrayList<jm.music.data.Note>();
		rhythms = new ArrayList<Double>();

		String scoreName = "score_" + filename;
		Score theScore = new Score(scoreName);

		// read the midi file into a score
		Read.midi(theScore, filename);

		// extract the melody and all its parts
		Part part = theScore.getPart(whichLine);
		Phrase[] phrases = part.getPhraseArray();

		// extract all the pitches and notes from the melody
		for (int i = 0; i < phrases.length; i++) {
			jm.music.data.Note[] notes = phrases[i].getNoteArray();

			for (int j = 0; j < notes.length; j++) {
				pitches.add(notes[j].getPitch());
				rhythms.add(notes[j].getDuration());
				melody.add(notes[j]);
			}

		}
	}

	public Integer[] getPitches() {
		return pitches.toArray(new Integer[pitches.size()]);
	}

	public ArrayList<Integer> getPitchArray() {
		return pitches;
	}

	public ArrayList<Double> getRhythmArray() {
		return rhythms;
	}

	public ArrayList<jm.music.data.Note> getMelody() {
		return melody;
	}

	public Double[] getRhythms() {
		return rhythms.toArray(new Double[rhythms.size()]);
	}

}