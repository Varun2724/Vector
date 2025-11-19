package Vector;
class MyIndexOutOfBoundsException extends RuntimeException
{
	MyIndexOutOfBoundsException()
	{
		super();
	}
}

class MyVector<E>
{
	static final int INITIAL_CAPACITY=10;
	E [] arr;
	int indx;
	int increment=0;


	MyVector()
	{
		super();
		arr=(E []) new Object[INITIAL_CAPACITY];
	}
	MyVector(int capacity)
	{
		super();
		arr=(E[]) new Object[capacity]; 
	}
	MyVector(int capacity,int increment)
	{
		super();
		this.increment=increment;
		arr=(E[]) new Object[newCap(capacity,increment)];
		
	}

	public int newCap(int capc,int increment)
	{
		if(increment>0)
		{
			return capc+increment;
		}
		
		return capc*2;
	}

	public String toString()
	{
		String data="[";
		int i=0;
		if(indx==0)return "[]";
		else{
			for(i=0;i<size()-1;i++)
			{
				data+=arr[i]+", ";
			}
			data+=arr[size()-1]+"]";
		}
		return data;
	}

	public void addElement(E ele)
	{
		if(indx==arr.length)
		{
			E [] newArr=(E[])new Object[newCap(arr.length,increment)];
			for(int i=0;i<indx;i++)
			{
				newArr[i]=arr[i];
			}
			arr=newArr;
		}
		
			arr[indx]=ele;
		
		indx++;
	}

	public int size()
	{
		return indx;
	}

	public int capacity()
	{
		return arr.length;
	}

	public E firstElement()
	{
		return arr[0];
	}

	public E lastElement()
	{
		return arr[size()-1];
	}

	public int indexOf(E ele)
	{
		for(int i=0;i<size();i++)
		{
			if(arr[i].equals(ele))
			{
				return i;
			}
		}
		return -1;
	}

	public int lastIndexOf(E ele)
	{
		int lastIndx=-1;
		for(int i=0;i<size();i++)
		{
			if(arr[i].equals(ele))
			{
				lastIndx=i;
			}
		}
		return lastIndx;
	}

	public E removeElementAt(E ele)
	{
		E temp=null;
		for(int i=0;i<size();i++)
		{
			if(arr[i].equals(ele))
			{
				temp=arr[i];
				int in=i;
				for(int j=in;j<size();j++)
				{
            arr[j]=arr[i+1];
            i++;
				}
			}
		}
		indx--;
		return temp;
	}
	public void clear()
	{
		indx=0;
	}

	public E get(int indx)
	{
		if(indx<0 || indx>size())
		{
			throw new MyIndexOutOfBoundsException();
		}

		return arr[indx];
	}

	public E set(int indx,E ele)
	{
		E temp=arr[indx];
		arr[indx]=ele;

		return temp;
	}
}

class VectorDriver
{
	public static void main(String[] args) {
		// Vector<Integer> vec=new Vector<>();
		MyVector<Integer> vec=new MyVector<>(5,3);
		vec.addElement(10); 
		vec.addElement(20); 
		vec.addElement(30); 
		vec.addElement(40);
		vec.addElement(50);
		vec.addElement(60);
		vec.addElement(70);
		vec.addElement(80);
		vec.addElement(90);
		vec.addElement(100);
		System.out.println(vec);
		System.out.println("cap : "+vec.capacity());

		vec.addElement(110);
		vec.addElement(120);
		vec.addElement(60);
		vec.addElement(130);
		vec.addElement(140);
		System.out.println(vec);
		System.out.println("cap : "+vec.capacity());

		System.out.println("firstElement() : "+vec.firstElement());
		System.out.println("lastElement() : "+vec.lastElement());

		System.out.println("indexof(30) : "+vec.indexOf(30));

		System.out.println("lastIndexOf(60) : "+vec.lastIndexOf(60));

		System.out.println("removeElementAt(30) : "+vec.removeElementAt(30));
		System.out.println(vec);

		System.out.println("get(7) : "+vec.get(7));

		System.out.println("set(4,600) : "+vec.set(4,600));
		System.out.println(vec);

		vec.clear();
		System.out.println(vec);
	}
}
