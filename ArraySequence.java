import java.util.NoSuchElementException;
public class ArraySequence implements IntegerSequence{
  int currentIndex;
  int[] data;

  /*Construct the sequence by copying values from the other array into the data array*/
  public ArraySequence(int [] other){
    data = new int[other.length];
    for (int i = 0; i<other.length; i++){
      this.data[i] = other[i];
    }
    currentIndex = 0;
  }

  //Postcondition: The otherseq will be reset.
  //This constructor will copy ALL values of the `otherseq` into the data array.
  public ArraySequence(IntegerSequence otherseq){
    otherseq.reset();
    data = new int[otherseq.length()];
    currentIndex = 0;
    while(otherseq.hasNext()){
      this.data[currentIndex] = otherseq.next();
      currentIndex++;
    }
    currentIndex = 0;
    otherseq.reset();
  }

  public void reset(){
    currentIndex = 0;
  }

  public int length(){
    return this.data.length;
  }

  public int next(){
    if (!hasNext()){
      throw new NoSuchElementException();
    }
    currentIndex++;
    return this.data[currentIndex-1];
  }

  public boolean hasNext(){
    return (currentIndex < length());
  }
}
