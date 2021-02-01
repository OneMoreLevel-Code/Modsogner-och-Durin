/*
 * author: Felix Cederblad
 * mail: felix_cederblad@hotmail.com
 * username: fece4341
 */
public class Andel 
{
	private int procent;
	public Andel(int procent)
	{
		this.setProcent(procent);
	}
	public int getProcent() 
	{
		return procent;
	}
	public void setProcent(int procent) 
	{
		this.procent = procent;
	}
	public String toString()
	{
		return Integer.toString(procent);
	}
}
