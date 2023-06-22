import com.example.bio.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BiologyTermAdapter extends RecyclerView.Adapter<BiologyTermAdapter.ViewHolder> {

    public  List<BiologyTerm> biologyTerms;

    public BiologyTermAdapter(List<BiologyTerm> biologyTerms) {
        this.biologyTerms = biologyTerms;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_biology_term, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BiologyTerm biologyTerm = biologyTerms.get(position);
        holder.bind(biologyTerm);
    }

    @Override
    public int getItemCount() {
        return biologyTerms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView termTextView;
        private TextView explanationTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            termTextView = itemView.findViewById(R.id.termTextView);
            explanationTextView = itemView.findViewById(R.id.explanationTextView);
        }

        public void bind(BiologyTerm biologyTerm) {
            termTextView.setText(biologyTerm.getBodyPart());
            explanationTextView.setText(biologyTerm.getExplanation());
        }
    }
}
