/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

/**
 *
 * @author lipiri
 */
public class operaciones {
    String m[][];
    
    public String convertir_A_matriz(String dato){
        
        operaciones f=new operaciones();
        String v[]=dato.split("\n");
       int col= f.columnas(v);
       m=new String[v.length][col];
       for(int i=0;i<v.length;i++){
           for(int j=0;j<col;j++){
               m[i][j]=" ";
               //System.out.print(m[i][j]+" ");
           }//System.out.println();
       }
      m=f.ingresar_matriz(v,m);//ingresar a matriz los datos
      /*for(int i=0;i<v.length;i++){
           for(int j=0;j<col;j++){
               System.out.print(m[i][j]);
           }System.out.println();
       }  */
     
      String acarreo="";//1111
      for(int i=col-1;i>=0;i--){
          if(i==col-1){
            acarreo=f.ejerci(m,i,v.length);
            System.out.println(acarreo);
          }else{
              String valor="";
              String acarreo_temporal="";
              if(acarreo.length()>1){
                  char v1[]=acarreo.toCharArray();
                  for(int k=0;k<acarreo.length()-1;k++){
                            if(v1[k]==v1[k+1]){
                      if(v1[k]=='1'&&v1[k+1]=='1'){
                          acarreo_temporal=acarreo_temporal+"1";
                          v1[k+1]='0';
                          valor="0";
                      }else{
                          v1[k+1]='0';
                          valor="0";
                      }

                  }else{
                         v1[k+1]='1';
                         valor="1";
                    }
                  }
              }else{
                  if(acarreo.equals(" ")){
                  }else{
                      valor=acarreo;
                  }
              
              }
              if(valor!=" "){
                  if(m[0][i].equals(valor)){
                      if(m[0][i].equals("1")&valor.equals("1")){
                          acarreo_temporal=acarreo_temporal+"1";
                          m[0][i]="0";
                      }else{
                          m[0][i]="0";
                      }
                  }else{
                      if(m[0][i].equals(" ")||m[0][i].equals("0")){
                       m[0][i]="1";
                      }
                  }
              }
              acarreo="";
              acarreo=acarreo_temporal;
              acarreo=acarreo+f.ejerci(m,i,v.length);
              System.out.println("acrreo"+acarreo);
          }
      }
      String part1="";
      String part2="";
      for(int i=0;i<col;i++){
          part1=part1+(m[v.length-1][i]);
      }
      System.out.println("par+"+part1);
      String total="";
      if(acarreo.length()<=1){
          total=acarreo+part1;
      }else{
          String acarreo_t="";
          String valor="";
          while(acarreo.length()>1){
              char v1[]=acarreo.toCharArray();
                  for(int k=0;k<acarreo.length()-1;k++){
                            if(v1[k]==v1[k+1]){
                      if(v1[k]=='1'&&v1[k+1]=='1'){
                          acarreo_t=acarreo_t+"1";
                          v1[k+1]='0';
                          valor="0";
                      }else{
                          v1[k+1]='0';
                          valor="0";
                      }

                  }else{
                         v1[k+1]='1';
                         valor="1";
                    }
                  }
                  part2=valor+part2;
                  acarreo=acarreo_t;
          }
          part2=acarreo+part2;
       
      total=part2+part1;   
      }
      System.out.println(total);
      
      
      return total;
    
    }
    public String ejerci(String m[][],int i,int tam){
        String ac="";
        for(int j=0;j<tam-1;j++){
            if(m[j][i].equals(m[j+1][i])){
                if(m[j][i].equals("1")&&m[j+1][i].equals("1")){
                    ac=ac+"1";
                    m[j+1][i]="0";
                }else{
                    m[j+1][i]="0";
                }
               
            }else{
                if(m[j+1][i].equals(" ")){
                m[j+1][i]=m[j][i];
                }else{
                    m[j+1][i]="1";
                }
            
            }
        }
        return ac;
    }
    
    public String[][] ingresar_matriz(String v[],String m[][]){
       
        for(int i=0;i<v.length;i++){
           char v1[]=v[i].toCharArray();
           int u=0;
           for(int j=0;j<v1.length;j++){
               if(v1[j]==' '){
                   m[i][u]=" ";u++;
               }else{
                   m[i][u]=""+v1[j];u++;
               }
           
           }//System.out.println();
       }
        return m;
    
    }
    public int columnas(String v[]){
        int mayo=0;
        for(int i=0;i<v.length;i++){
                if(v[i].length()>=mayo){
                    mayo=v[i].length();
                }
        }
        return mayo;
    
    }
}
