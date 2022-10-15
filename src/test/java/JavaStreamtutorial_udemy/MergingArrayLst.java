package JavaStreamtutorial_udemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MergingArrayLst {
	@Test
	public void MergeArray() {
		//List one 
		ArrayList<String> name1=new ArrayList<String>();
		name1.add("Man");
		name1.add("woman");
		name1.add("child");
		
		//List Two
		 List<String> name2=  Arrays.asList("Jini","Tani","Srijith","Sriram","Tanu","Tabu");
		    //name2.stream().filter(s->s.startsWith("T")).sorted().map(s->s.toUpperCase())
		   // .forEach(s->System.out.println(s));
		 //Merging two list 
		    Stream<String> newnames=Stream.concat(name1.stream(), name2.stream());
		   //sorting the new name list and printing 
		  newnames.sorted().forEach(s->System.out.println(s));
		  Stream<String> newnames1=Stream.concat(name1.stream(), name2.stream());
		   boolean flag=newnames1.anyMatch(s->s.equalsIgnoreCase("tani"));
		   System.out.println(flag);
		    Assert.assertTrue(flag);
		    
		    
    
	}
	@Test
	public void streamCollect() {
		List<String> ls=Stream.of("India","Australia","alexandria","Leppington").filter(s->s.endsWith("a"))
		.map(s->s.toUpperCase()).collect(Collectors.toList());
		
		System.out.println(ls.get(2));
		
	}
	
	@Test
	public void uniqueNumberStream() {
		List<Integer> num=Arrays.asList(3,2,2,5,1,9,7);
		System.out.println("the list atre");
		num.stream().distinct().sorted().forEach(s->System.out.println(s));
		List<Integer> li=num.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println("the number from the 3rd index is " + " " + li.get(3));
		
	}

}
