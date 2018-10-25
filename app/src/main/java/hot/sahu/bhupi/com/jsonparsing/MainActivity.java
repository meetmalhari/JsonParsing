package hot.sahu.bhupi.com.jsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String jsonString="{\"Info\":[{\"Name\":\"Malhari\",\"Age\":26,\"Sub\":[30,40,50]},{\"Name\":\"Rakesh\",\"Age\":27,\"Sub\":[32,44,58]}]}";

        try {
            JSONObject jsonObject1=new JSONObject(jsonString);
            JSONArray jsonArray=jsonObject1.getJSONArray("Info");
//            JSONArray jsonArray=new JSONArray(jsonString);
            int len=jsonArray.length();
            String ans="";
            for(int i=0;i<len;i++)
            {
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                    JSONArray jsonArray1=jsonObject.getJSONArray("Sub");
                    int length=jsonArray1.length();
                    int sum=0;
                    for(int j=0;j<length;j++)
                        sum+=jsonArray1.getInt(j);

                String s=""+"\n"+jsonObject.getString("Name")+"    Age => "+jsonObject.getInt("Age")+"  Total Marks => "+sum;

            ans+=s;

            }

            TextView textView=findViewById(R.id.txtView);
            textView.setText(""+ans);



        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("Info "," Error "+e.getMessage());
        }

    }
}
