package JavaStreamtutorial_udemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class test {
	
	public void regular(){
		
		ArrayList<String> names=new ArrayList<String>();	
		names.add("Jini");
		names.add("Tanisha");
		names.add("Srijith");
		names.add("Sriram");
		names.add("Tanya");
		names.add("Tabu");
		int count=0;
		
		for(int i=0;i<names.size();i++)
		{
			
			String actualName=names.get(i);
			if(actualName.startsWith("T"))
			{
				count++;
				
			}
		}
		System.out.println(count);
		
		
		
	}
	@Test
	public void streamfilter() {
		ArrayList<String> names=new ArrayList<String>();	
		names.add("Jini");
		names.add("Tanisha");
		names.add("Srijith");
		names.add("Sriram");
		names.add("Tanya");
		names.add("Tabu");
		//there is no life for intermediate operator(s->s.Startswith())  without terminal opertaot
	//(count())	
		//Terminal operator will execute only if the intermediate operator return true
		//we can create stream
		//how to use filter in stream API
		Long c=names.stream().filter(s->s.startsWith("T")).count();
		System.out.println(c);
	//names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
	}
	@Test
	public void streamMap() {
		
		Stream.of("Jini","Tanisha","Srijith","Sriram","Tanya","Tabu")
		       .filter(s->s.endsWith("a")).map(s->s.toLowerCase())
		       .forEach(s->System.out.println(s));;
		
	//print the names which has first letter as T and
		//it converted to upper-case and sorted into array
		    List<String> name=  Arrays.asList("Jini","Tani","Srijith","Sriram","Tanu","Tabu");
		    name.stream().filter(s->s.startsWith("T")).sorted().map(s->s.toUpperCase())
		    .forEach(s->System.out.println(s));
	
	
	}

}
