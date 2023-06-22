
import com.example.bio.R;

public class BiologyTerm {
    private String bodyPart;
    private String explanation;

    public BiologyTerm(String bodyPart, String explanation) {
        this.bodyPart = bodyPart;
        this.explanation = explanation;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public String getExplanation() {
        return explanation;
    }
}
