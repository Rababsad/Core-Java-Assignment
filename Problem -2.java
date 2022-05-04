import java.util.Scanner;
public class Shapes {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.println("Select the Shape to calculate Area,Perimeter and Volume(3-D) for :" );
        System.out.println("1. Circle :" );
        System.out.println("2. Rectangle :" );
        System.out.println("3. Triangle :" );
        System.out.println("4. Square :" );
        System.out.println("5. Parallelogram :" );
        System.out.println("6. Cube :" );
        System.out.println("7. Sphere :" );
        System.out.println("8. Cylinder :" );
        System.out.println("\n Enter your choice :");
        switch(in.nextInt())
        {
            case 1 :
                    System.out.println("Enter radius of the Circle:  " );
                    double rad = in.nextDouble();
                    double cp =  2*(22/7.0)*rad;
                    double ca =  (22/7.0)*rad*rad;
                    System.out.println("Perimeter of the Circle :" + cp );
                    System.out.println("Area of the Circle :" + ca ); 

                    break;
                
            case 2 :
                    System.out.println("Enter length of the Rectangle :" );
                    double l = in.nextDouble();
                    System.out.println("Enter breadth of the Rectangle:" );
                    double b = in.nextDouble();
                    double rp = 2*(l+b);
                    double ra = l+b;
                    System.out.println("Perimeter of the Rectangle :" + rp );
                    System.out.println("Area of the Rectangle :" + ra );

                    break;

             case 3 :
                    System.out.println("Enter side 1 of the Traingle:" );
                    double a = in.nextDouble();
                    System.out.println("Enter side 2 of the Traingle:" );
                    double c = in.nextDouble();
                    System.out.println("Enter base of the Traingle:" );
                    double ba= in.nextDouble();
                    System.out.println("Enter height of the Traingle:" );
                    double h = in.nextDouble();
                    double tp = a+ba+c;
                    double ta = 0.5*ba*h;
                    System.out.println("Perimeter of the Traingle :" + tp );
                    System.out.println("Area of the Traingle:" + ta );

                    break;

            case 4 :
                    System.out.println("Enter side of the Square :" );
                    double side = in.nextDouble();
                    double sp = 4*side;
                    double sa = side*side;
                    System.out.println("Perimeter of the Square :" + sp );
                    System.out.println("Area of the Square :" + sa );

                    break;

            case 5 :
                    System.out.println("Enter side of the Paralleogram :" );
                    double side1 = in.nextDouble();
                    System.out.println("Enter base of the Paralleogram :" );
                    double base = in.nextDouble();
                    System.out.println("Enter height of the Paralleogram :" );
                    double height = in.nextDouble();
                    double pp = 2*(side1+base);
                    double pa = base*height;
                    System.out.println("Perimeter of the Parallelogram :" + pp );
                    System.out.println("Area of the Parallelogram :" + pa );

                    break;
            
           case 6 :
                    System.out.println("Enter side of the Cube:" );
                    double cubeSide = in.nextDouble();
                    double cubePer = 12*cubeSide;
                    double cubeTsa = 6*cubeSide*cubeSide;
                    double cubeVol = cubeSide*cubeSide*cubeSide;
                    System.out.println("Perimeter of the Cube :" + cubePer );
                    System.out.println(" Total Surface Area of the Cube :" +  cubeTsa );
                    System.out.println("Volume of the Cube :" + cubeVol );

                    break;

         
            case 7 :
                    System.out.println("Enter radius of the Sphere:" );
                    double sphereRad = in.nextDouble();
                    double sphereArr = 4*(22/7.0)*sphereRad*sphereRad;
                    double sphereVol = (4.0/3)*(22/7.0)*sphereRad*sphereRad;
                    System.out.println(" Area of the Sphere :" +  sphereArr );
                    System.out.println("Volume of the Sphere :" + sphereVol );

                    break;

            case 8 :
                    System.out.println("Enter radius of the Cylinder:" );
                    double cylinderRad = in.nextDouble();
                    System.out.println("Enter height of the Cylinder:" );
                    double cylinderHt = in.nextDouble();
                    double cylinderLsa = 2 * Math.PI * cylinderRad * cylinderHt;
                    double cylinderTsa = 2 * Math.PI * cylinderRad * (cylinderRad + cylinderHt);
                    double cylinderVol = Math.PI * cylinderRad * cylinderRad * cylinderHt;
                    System.out.println(" Lateral surface area of the Cylinder :" +  cylinderLsa );
                    System.out.println(" Total  surface area of the Cylinder :" +  cylinderTsa );
                    System.out.println("Volume of the Cylinder :" + cylinderVol );

                    break;

            default :
                     System.out.println("Wrong choice :");
            }             
        in.close();           


        }
}



        
        
        

    

    

