package kr.co.web.model.Like;

public class LikeDto {

	private String lu_id;
	private int lseq;
	private int like_check;
	private int likeno;
	public String getLu_id() {
		return lu_id;
	}
	public void setLu_id(String lu_id) {
		this.lu_id = lu_id;
	}
	public int getLseq() {
		return lseq;
	}
	public void setLseq(int lseq) {
		this.lseq = lseq;
	}
	public int getLike_check() {
		return like_check;
	}
	public void setLike_check(int like_check) {
		this.like_check = like_check;
	}
	public int getLikeno() {
		return likeno;
	}
	public void setLikeno(int likeno) {
		this.likeno = likeno;
	}
	@Override
	public String toString() {
		return "LikeDto [lu_id=" + lu_id + ", lseq=" + lseq + ", like_check=" + like_check + ", likeno=" + likeno + "]";
	}

}