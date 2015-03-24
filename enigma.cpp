#include<iostream>
#include<string.h>
using namespace std;
int r,m,l;

//char right(char);
int mid(int);
int left(int);
int rotate(int);
int right_r(int);
int mid_r(int);
int left_r(int);
int rotate(int);
int right(int c){
	c=c+r;
	if(c>'z')
		c='a'+c-'z'-1;
//cout<<"check1"<<endl;
	
	return mid(c);
}

int mid(int c){
	c=c+m;
	if(c>'z')
		c='a'+c-'z'-1;
//cout<<"check2"<<endl;
	return left(c);
}

int left(int c){
	c=c+l;
	if(c>'z')
		c='a'+c-'z'-1;
//cout<<"check3"<<endl;
	return rotate(c);
}

int rotate(int c){
	/*l='z'-l-'a';
	m='z'-m-'a';
	r='z'-r-'a';*/
	if(c-'a'<13){
		c=c+13;
	}	
	else{
		c=c-13;
	}
//cout<<"check4"<<endl;
	return left_r(c);
}
int left_r(int c){
	//l='z'-l+'a';
	c=c+l;
	if(c>'z')
		c='a'+c-'z'-1;
//cout<<"check5"<<endl;
	return mid_r(c);
}

int mid_r(int c){
	//m='z'-m+'a';
	c=c+m;
	if(c>'z')
		c='a'+c-'z'-1;
//cout<<"check6"<<endl;
	return right_r(c);
}


int right_r(int c){
	//r='z'-r+'a';
	c=c+r;
	if(c>'z')
		c='a'+c-'z'-1;
//cout<<"check7"<<endl;
	return c;
}
int main(){
	char a,b,c;
	char s[100];
	lb:
	cout<<"Enigma Machine"<<endl;
	cout<<"Enter Message : ";
	gets(s);
	cout<<"Initiate the rotors : ";
	cin>>a>>b>>c;
	r=a-'a';
	m=b-'a';
	l=c-'a';
	cout<<endl<<r<<' '<<m<<' '<<l<<endl<<endl;
	cout<<"Ans is : ";
	for(int i=0;i<strlen(s);i++){
		if(s[i]!=' ')
		{
		char p =(char)right(s[i]);
		cout<<p;
		}
		else{
			cout<<' ';
		}
	}
	
	cout<<endl<<"Press s to reset : ";
	char temp;
	cin>>temp;
	if(temp=='s'){
		fflush(stdin);
		goto lb;
	}
	
	return 0;
}
