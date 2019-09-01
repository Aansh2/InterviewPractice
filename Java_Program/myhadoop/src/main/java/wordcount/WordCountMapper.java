package wordcount;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by nikhil on 4/3/18.
 */
public class WordCountMapper extends Mapper<LongWritable,Text, Text, IntWritable>{


     public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
         String w = value.toString();
         StringTokenizer tokenizer = new StringTokenizer(w);
         while (tokenizer.hasMoreTokens()) {
              context.write(new Text(tokenizer.nextToken()),  new IntWritable(1));
         }
      }





}
