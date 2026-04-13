package org.themoviedb.www.movie.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.themoviedb.www.movie.service.MovieService;
import org.themoviedb.www.movie.vo.MovieVO;
import org.themoviedb.www.movie.vo.request.UpdateVO;
import org.themoviedb.www.movie.vo.response.SearchResultVO;
import org.themoviedb.www.movie.vo.response.SelectResultForMovieUrlVO;

import jakarta.validation.Valid;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@GetMapping("/")
	public String viewIntroPage() {
		return "intro";
	}

	@GetMapping("/list")
	public String viewMovieListPage(Model model) {
		// 영화 목록을 가져오기
		SearchResultVO searchResult = this.movieService.findAllMovies();

		List<MovieVO> movieList = searchResult.getResult();

		model.addAttribute("movieCount", searchResult.getCount());
		model.addAttribute("movieResult", movieList);

		return "list";

	}

	@GetMapping("/write")
	public String viewMWritePage() {

		return "write";
	}
	
	@PostMapping("/write")
	public String doWriteAction(@Valid @ModelAttribute MovieVO movieVO, BindingResult bindingResult,Model model) { 
		 
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("inputData", movieVO);
			return "write";
		}
		String posterUrl = "tasad";
		movieVO.setPosterUrl(posterUrl);
		
		String title = movieVO.getTitle();
		title = title.replace("<", "&lt;")
					 .replace(">", "&gt;");
		movieVO.setTitle(title);
		
		// 여따 적는 이유 : 다른 진입경로에서 들어오는 공격 막기 위함
		
		boolean creatResult = this.movieService.creatNewMovie(movieVO);
		return "redirect:/list";
	}
	
	@GetMapping("/view/{movieId}")
	public String viewMovieDetailPage(@PathVariable String movieId, Model model) {
		SelectResultForMovieUrlVO movieVO = this.movieService.findMovieByMovieId(movieId);
		model.addAttribute("movieVO", movieVO); 
		
		return "view";
	}	
	
	@GetMapping("/update/{movieId}")
	public String updateMoviePage(@PathVariable String movieId, Model model) {
		SelectResultForMovieUrlVO movieVO = this.movieService.findMovieByMovieId(movieId);
		
		model.addAttribute("updateVO", movieVO);  
		return "update";
	}
	@PostMapping("/update/{movieId}")
	public String updateMovieAction(@Valid @ModelAttribute UpdateVO UpdateVO, BindingResult bindingResult ,@PathVariable String movieId, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("inputData", UpdateVO);
			return "write";
		}
		
		UpdateVO.setMovieId(movieId);
		String posterUrl = "tasad";
		UpdateVO.setPosterUrl(posterUrl);
		
		String title = UpdateVO.getTitle();
		title = title.replace("<", "&lt;")
					 .replace(">", "&gt;");
		UpdateVO.setTitle(title); 
		
		boolean updateResult = this.movieService.updateMovie(UpdateVO);
		return "redirect:/list";
	}
	
	

}

