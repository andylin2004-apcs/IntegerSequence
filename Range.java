public interface IntegerSequence{
  boolean hasNext() ;//does the sequence have more elements?
  int next();         //return the current value in the sequence and advances to the next element
  int length();     //returns the total length of the sequence
  void reset();     //start over from the start of the sequence
}

import java.util.NoSuchElementException;
public class Range implements IntegerSequence{
  private int start,end,current;

  //@param start : the starting value (inclusive) which must be <= end.
  //@param end : the ending value which is also inclusive.
  public Range(int start,  int end){
    this.start = start;
    this.end = end;
  }

  public void reset(){  }
  public int length(){
    return (this.end-this.start);
  }

  //When current is no longer a valid element in the range, it should return false.
  public boolean hasNext(){
    return (current + 1 >= end) || (current + 1 <= start);
  }

  //@throws NoSuchElementException when hasNext() is false.
  //This will return the current value, it will also increase current value by 1.
  //e.g.  if current is 5. This will make current 6, and return 5.
  public int next(){
    current++;
    return current - 1;
  }

}
