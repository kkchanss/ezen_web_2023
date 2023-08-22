package model.dto;

public class VisitDto {

   private int vno;
   private String vwriter;
   private String vpwd;
   private String vcontent;
   private String vday;
   
   public VisitDto(){}
   
   public VisitDto(int vno, String vwriter, String vpwd, String vcontent, String vday) {
      super();
      this.vno = vno;
      this.vwriter = vwriter;
      this.vpwd = vpwd;
      this.vcontent = vcontent;
      this.vday = vday;
   }

   
	public VisitDto(String vwriter, String vpwd, String vcontent) {
		super();
		this.vwriter = vwriter;
		this.vpwd = vpwd;
		this.vcontent = vcontent;
	}




public int getVno() {
      return vno;
   }

   public void setVno(int vno) {
      this.vno = vno;
   }

   public String getVwriter() {
      return vwriter;
   }

   public void setVwriter(String vwriter) {
      this.vwriter = vwriter;
   }

   public String getVpwd() {
      return vpwd;
   }

   public void setVpwd(String vpwd) {
      this.vpwd = vpwd;
   }

   public String getVcontent() {
      return vcontent;
   }

   public void setVcontent(String vcontent) {
      this.vcontent = vcontent;
   }

   public String getVday() {
      return vday;
   }

   public void setVday(String vday) {
      this.vday = vday;
   }

   @Override
   public String toString() {
      return "VisitlogDto [vno=" + vno + ", vwriter=" + vwriter + ", vpwd=" + vpwd + ", vcontent=" + vcontent
            + ", vday=" + vday + "]";
   }

   
   
   
}