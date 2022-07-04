package kr.co.web.model.Product;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class productDto {

	private int seq;
	private String category;
	private String title;
	private String contents;
	private String price;
	private String view_count;
	private String display_yn;
	private Date create_date;
	private String writer;
	private MultipartFile photo;
	private String photoName;
	private String title_photo;
	private int likecnt;
	private String u_id;
	public productDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public productDto(int seq, String category, String title, String contents, String price, String view_count,
			String display_yn, Date create_date, String writer, MultipartFile photo, String photoName,
			String title_photo, int likecnt, String u_id) {
		super();
		this.seq = seq;
		this.category = category;
		this.title = title;
		this.contents = contents;
		this.price = price;
		this.view_count = view_count;
		this.display_yn = display_yn;
		this.create_date = create_date;
		this.writer = writer;
		this.photo = photo;
		this.photoName = photoName;
		this.title_photo = title_photo;
		this.likecnt = likecnt;
		this.u_id = u_id;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getView_count() {
		return view_count;
	}
	public void setView_count(String view_count) {
		this.view_count = view_count;
	}
	public String getDisplay_yn() {
		return display_yn;
	}
	public void setDisplay_yn(String display_yn) {
		this.display_yn = display_yn;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getTitle_photo() {
		return title_photo;
	}
	public void setTitle_photo(String title_photo) {
		this.title_photo = title_photo;
	}
	public int getLikecnt() {
		return likecnt;
	}
	public void setLikecnt(int likecnt) {
		this.likecnt = likecnt;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	@Override
	public String toString() {
		return "productDto [seq=" + seq + ", category=" + category + ", title=" + title + ", contents=" + contents
				+ ", price=" + price + ", view_count=" + view_count + ", display_yn=" + display_yn + ", create_date="
				+ create_date + ", writer=" + writer + ", photo=" + photo + ", photoName=" + photoName
				+ ", title_photo=" + title_photo + ", likecnt=" + likecnt + ", u_id=" + u_id + "]";
	}
	
	

}