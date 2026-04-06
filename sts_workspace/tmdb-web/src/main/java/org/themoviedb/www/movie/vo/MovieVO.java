package org.themoviedb.www.movie.vo;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;

public class MovieVO { 
	private String movieId;
	private String posterUrl;
	@NotEmpty(message="Required Title")
	private String title;
	private String movieRating;
	private String openDate;
	private String openCountry;
	private int runningTime;
	private String introduce;

	@NotEmpty(message="Required synopsis")
	private String synopsis;
	private String originalTitle;
	private String state;

	@NotEmpty(message="Required language")
	private String language;
	private int budget;
	private int profit;

	private MultipartFile attachFile;
	
	  
	public String getMovieId() {
		if(this.movieId != null) {
			this.movieId = this.movieId.replace("<", "&lt;")
					 				   .replace(">", "&gt;");
		}
		return this.movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getOpenDate() {if(this.openDate != null) {
		this.openDate = this.openDate.replace("<", "&lt;")
				   .replace(">", "&gt;");
}
		return this.openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	public MultipartFile getAttachFile() { 
		return this.attachFile;
	}
	public void setAttachFile(MultipartFile attachFile) {
		this.attachFile = attachFile;
	}
	public String getPosterUrl() {if(this.posterUrl != null) {
		this.posterUrl = this.posterUrl.replace("<", "&lt;")
				   .replace(">", "&gt;");
}
		return this.posterUrl;
	}
	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	} 
	public String getTitle() {if(this.title != null) {
		this.title = this.title.replace("<", "&lt;")
				   .replace(">", "&gt;");
}
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMovieRating() {if(this.movieRating != null) {
		this.movieRating = this.movieRating.replace("<", "&lt;")
				   .replace(">", "&gt;");
}
		return this.movieRating;
	}
	public void setMovieRating(String movieRating) {
		this.movieRating = movieRating;
	}
	public String getOpenCountry() {if(this.openCountry != null) {
		this.openCountry = this.openCountry.replace("<", "&lt;")
				   .replace(">", "&gt;");
}
		return this.openCountry;
	}
	public void setOpenCountry(String openCountry) {
		this.openCountry = openCountry;
	}
	public int getRunningTime() {
		return this.runningTime;
	}
	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}
	public String getIntroduce() {if(this.introduce != null) {
		this.introduce = this.introduce.replace("<", "&lt;")
				   .replace(">", "&gt;");
}
		return this.introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getSynopsis() {if(this.synopsis != null) {
		this.synopsis = this.synopsis.replace("<", "&lt;")
				   .replace(">", "&gt;");
}
		return this.synopsis;
	}
	public void setSynopsis(String sysnopsis) {
		this.synopsis = sysnopsis;
	}
	public String getOriginalTitle() {if(this.originalTitle != null) {
		this.originalTitle = this.originalTitle.replace("<", "&lt;")
				   .replace(">", "&gt;");
}
		return this.originalTitle;
	}
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}
	public String getState() {if(this.state != null) {
		this.state = this.state.replace("<", "&lt;")
				   .replace(">", "&gt;");
}
		return this.state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getLanguage() {if(this.language != null) {
		this.language = this.language.replace("<", "&lt;")
				   .replace(">", "&gt;");
}
		return this.language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getBudget() {
		return this.budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public int getProfit() {
		return this.profit;
	}
	public void setProfit(int profit) {
		this.profit = profit;
	}
	@Override
	public String toString() {
		return "MovieVO [ posterUrl=" + posterUrl + ", title=" + title + ", movieRating="
				+ movieRating + ", openDate=" + openDate + ", openCountry=" + openCountry + ", runningTime="
				+ runningTime + ", introduce=" + introduce + ", sysnopsis=" + synopsis + ", originalTitle="
				+ originalTitle + ", state=" + state + ", language=" + language + ", budget=" + budget + ", profit="
				+ profit + "]";
	} 
	 
}
