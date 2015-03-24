package com.example.enigma;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
char key='s';
String bj;
char[] temp;
char[] a;
String str,tmp;
int p =0;
int r,m,l;
//int ra,ma,la;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final EditText xx = (EditText) findViewById(R.id.editText1);
        final EditText xy = (EditText) findViewById(R.id.editText2);
        
        final EditText nm = (EditText) findViewById(R.id.editText3);
        final EditText nmm = (EditText) findViewById(R.id.editText5);
        final EditText nmmm = (EditText) findViewById(R.id.editText4);
        
        final Button clr = (Button) findViewById(R.id.clr_btn);
        clr.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View arg0) {
        	String s = new String();
        	xx.setText(s);
			xy.setText(s);
        	}
        });
        
        final Button btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				str = xx.getText().toString();
				temp = str.toCharArray();
				
				tmp = nm.getText().toString();
				
				r=tmp.charAt(0);
				r=r-'a';
				tmp = nmm.getText().toString();
				
				m=tmp.charAt(0);
				m=m-'a';
				tmp = nmmm.getText().toString();
				if(tmp.matches("")){
					Toast.makeText(getBaseContext(), "Rotors cannot be left empty.." , 
							 Toast.LENGTH_SHORT).show();
				}
				l=tmp.charAt(0);
				l=l-'a';
				if(p%2!=0){
					int temporary= r+l+m;
					temporary = temporary % 26;
					temporary = 26 - temporary;
					r=0;
					m=0;
					l=temporary;
				}
				int i;
				for(i=0;i<str.length();i++){
					
					
					if(temp[i]>='a'&&temp[i]<='z'){
				//Right Start
					
				int tempo= (temp[i]+r);
				if(tempo>'z')
					tempo=('a'+tempo-'z'-1);
				//Right End
				
				//Mid Start
				tempo=(tempo+m);
				if(tempo>'z')
					tempo= ('a'+tempo-'z'-1);
				//Mid End
				
				//Left Start
				tempo=(tempo+l);
				if(tempo>'z')
					tempo= ('a'+tempo-'z'-1);
				//Left End
				
				//Rotate Start
					if(tempo-'a'<13){
						tempo= (tempo+13) ;
					}
					else{
						tempo=(tempo-13) ;
					}
			
				//Rotate End
				
				//Left Start
				tempo=(tempo+l);
				if(tempo>'z')
					tempo=('a'+tempo-'z'-1);
				//Left End
				
				//Mid Start
				tempo=(tempo+m);
				if(tempo>'z')
					tempo= ('a'+tempo-'z'-1);
				//Mid End
				
				//Right Start
				tempo=(tempo+r);
				if(tempo>'z')
					tempo=('a'+tempo-'z'-1);
				//Right End
				temp[i]=(char)tempo;
				}
					else if(temp[i]>='A'&&temp[i]<='Z'){
						int tempo= (temp[i]+r);
						if(tempo>'Z')
							tempo=('A'+tempo-'Z'-1);
						//Right End
						
						//Mid Start
						tempo=(tempo+m);
						if(tempo>'Z')
							tempo= ('A'+tempo-'Z'-1);
						//Mid End
						
						//Left Start
						tempo=(tempo+l);
						if(tempo>'Z')
							tempo= ('A'+tempo-'Z'-1);
						//Left End
						
						//Rotate Start
							if(tempo-'A'<13){
								tempo= (tempo+13) ;
							}
							else{
								tempo=(tempo-13) ;
							}
					
						//Rotate End
						
						//Left Start
						tempo=(tempo+l);
						if(tempo>'Z')
							tempo=('A'+tempo-'Z'-1);
						//Left End
						
						//Mid Start
						tempo=(tempo+m);
						if(tempo>'Z')
							tempo= ('A'+tempo-'Z'-1);
						//Mid End
						
						//Right Start
						tempo=(tempo+r);
						if(tempo>'Z')
							tempo=('A'+tempo-'Z'-1);
						//Right End
						temp[i]=(char)tempo;
					}
					
					
			}
				
				String b = new String(temp);
    			xy.setText(b);
    			
			}
		});
        
        final Button btn1 = (Button) findViewById(R.id.Button01);
        btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				if(p%2==0){
					String sp = xy.getText().toString();
					xx.setText(sp);
					String abc= "decoding...";
					//xy.setText(abc);
					String s = new String();
					xy.setText(s);
					xy.setHint(abc);
					p++;
				}
				else{
					String sp = xy.getText().toString();
					xx.setText(sp);
					/*
					tmp = nm.getText().toString();
					r=tmp.charAt(0);
					r=r-'a';
					tmp = nmm.getText().toString();
					m=tmp.charAt(0);
					m=m-'a';
					tmp = nmmm.getText().toString();
					l=tmp.charAt(0);
					l=l-'a';
					*/
					String abc="encoding...";
					//xy.setText(abc);
					String s = new String();
					xy.setText(s);
					xy.setHint(abc);
					p++;
				}
				
			}
        });
        
        
        xx.setOnKeyListener(new View.OnKeyListener(){
        	public boolean onKey(View v,int keyCode,KeyEvent event){
        		if((event.getAction()==KeyEvent.ACTION_DOWN)&&(keyCode==KeyEvent.KEYCODE_ENTER)){
        			btn.performClick();
        			return true;
        		}
        		return false;
        	}
        });
         
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        Toast.makeText(getBaseContext(), "property of Moulik Adak" , 
					 Toast.LENGTH_SHORT).show();
        return true;
    }
}
