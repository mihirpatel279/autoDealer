/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.Scanner;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Mihir
 */
@Named(value = "dealer")
@RequestScoped
public class Dealer {
    
    private int min;
    private int max;
    private String model;
    private Scanner input;
    private Formatter output;
    private String option;
    private ArrayList<Car> results = new ArrayList(); 

    
    

    /**
     * Creates a new instance of Dealer
     */
    public Dealer() {
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public ArrayList<Car> getResults() {
        return results;
    }

    public void setResults(ArrayList<Car> results) {
        this.results = results;
    }

    
    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    
    public String method()
    {
        
       
         openFile();
        records();
       closeFile();
       if(results.isEmpty())
       {
           return "error";
       }
       else
        
        return "result";
        
    }

    public void openFile() {
        
        try
        {
           input = new Scanner (new File ("C:\\Users\\Mihir\\Desktop\\autoDealer\\client.text")); 
        }
        catch(FileNotFoundException fe)
        {
            System.out.println("Error in opening file");
            System.exit(1);
        }
    }

    public void records() {
        
        Car c = new Car();
       while(input.hasNext())
       {
           
           try
           {
               
               c.setName(input.next());
               c.setPrice(input.nextInt());
               
               String a = c.getName();
              int b = c.getPrice();
              
              
              if(option.equals("Model"))
              {
                  if(model.equals(a))
                  {
                      results.add(new Car(a,b));
                      
                  }
                  
              }
              else if (option.equals("Price"))
              {
                  if(min < b && max > b)
                  {
                      results.add(new Car(a,b));
                      
                  }
              }
              else if (option.equals("ModelnPrice"))
              {
                  
                  if(min < b && max > b)
                  {
                     if(model.equals(a))
                    {
                      results.add(new Car(a,b));
                      
                    }
                      
                  }
                  
              }
               
           }
           catch(FormatterClosedException fe)
           {
               System.err.println("Error in reading file");
               
           }
       }
       
    }

    public void closeFile() {
        if(input!=null)
            input.close();
    }
    
//    
//      public void openFile1()
//    {
//        try
//        {
//         FileWriter fw = new FileWriter("record.text", true);  
//         output = new Formatter(fw);
//        }
//        catch(IOException e)
//        {
//            System.out.println("Error in opening file");
//            System.exit(1);
//        }
//        
//        
//    }
//    
//    public void records1()
//    {
//        Account ac = new Account();
//        Scanner input = new Scanner(System.in);
//        String selection = "y";
//        
//            
//                
//                try
//            {
//                
//                
//                ac.setNum(1);
//                ac.setName("Mihir");
//                ac.setBalance(50);
//                
//                output.format("%d %s %.2f%n",ac.getNum(),ac.getName(),ac.getBalance());
//                
//               
//                
//            }
//                catch(FormatterClosedException fe)
//        {
//            
//            return;
//        }
//            
//            
//        
//        
//        
//        
//    }
//    
//    public void closeFile1()
//    {
//        if(output != null)
//            output.close();
//        
//    }
    
    
}
