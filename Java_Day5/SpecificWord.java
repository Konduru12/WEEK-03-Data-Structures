public class SpecificWord{
    public static String findSentence(String[] sentences, String word) {
        for(String sentence:sentences){
            if(sentence.contains(word)){
                return sentence;
            }
        }
        return "Not Found";
    }
    public static  void main(String[] args){
        String[] sentences = {"Abhinaya is from AndhraPradesh. ",
                                "Sasanka is also from AndhraPradesh. ",
                                "Shasank and Bharath are from Rayalaseema. "};
        String word = "Abhinaya";
        String result = findSentence(sentences, word);
        System.out.println("The word is in the sentence: " + result);
    }
}