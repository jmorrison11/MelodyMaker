package melodymaker;
// TODO: Write the code for this class.

import java.util.Deque;
import java.util.LinkedList;


public class Melody
{
    Deque<Note> queue = new LinkedList();
    Deque<Note> stack = new LinkedList();    
     
    public Melody(Deque<Note> song){
        for(int i = 0; i < song.size(); i++){            
            Note notes = song.remove();
            queue.add(notes);
        }
    }    
    public double getTotalDuration() {
        double totalLength = 0;
        for(int i = 0; i < queue.size(); i++){     
            Note note = queue.remove();
            totalLength = note.getDuration() + totalLength;
            queue.add(note);
        }
        return totalLength;
    }     
    public void changeTempo(double tempo){
        for (int i = 0; i < queue.size(); i++) {
            Note note = queue.remove();
            double duration = note.getDuration() * tempo;
            note.setDuration(duration);
            queue.add(note);
        }
    }
    public void reverse(){
        for(int i = 0; i < queue.size(); i++){            
            Note notes = queue.remove();
            stack.add(notes);
            stack.pop();
            queue.add(notes);
        }
    }
    public void append(Melody other){
        for(int i = 0; i <= other.queue.size(); i++){
            Note notes = other.queue.poll();
            queue.add(notes);
            other.queue.add(notes);
        }
    }
    public void play(){
        for(int i = 0; i < queue.size(); i++){            
            Note note = queue.remove();
            note.play();
            queue.add(note);
        }
    }
    public String toString(){ 
        return "Notes:" + queue;
    }
}