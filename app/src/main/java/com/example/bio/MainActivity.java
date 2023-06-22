import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bio;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
   public    BiologyTermAdapter adapter;
    public  List<BiologyTerm> biologyTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Redirect to the splash screen activity
        Intent intent = new Intent(MainActivity.this, SplashScreenActivity.class);
        startActivity(intent);
        finish();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        biologyTerms = new ArrayList<>();

        // Add initial body parts and explanations
        biologyTerms.add(new BiologyTerm("Head", "The upper part of the body containing the brain, eyes, nose, mouth, and other sensory organs."));
        biologyTerms.add(new BiologyTerm("Chest", "The front part of the body between the neck and the abdomen, housing the heart and lungs."));
        biologyTerms.add(new BiologyTerm("Arm", "The upper limb of the body, extending from the shoulder to the hand."));
        biologyTerms.add(new BiologyTerm("Leg", "The lower limb of the body, extending from the hip to the foot."));
        // Add more body parts and explanations as needed

        adapter = new BiologyTermAdapter(biologyTerms);
        recyclerView.setAdapter(adapter);

        loadData();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("biology_terms", Context.MODE_PRIVATE);
        int termCount = sharedPreferences.getInt("term_count", 0);

        for (int i = 0; i < termCount; i++) {
            String termKey = "term_" + i;
            String explanationKey = "explanation_" + i;

            String term = sharedPreferences.getString(termKey, "");
            String explanation = sharedPreferences.getString(explanationKey, "");

            BiologyTerm biologyTerm = new BiologyTerm(term, explanation);
            biologyTerms.add(biologyTerm);
        }

        adapter.notifyDataSetChanged();
    }
}
