// package com.Movie.Ghibli.Controller;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// // import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// // import org.springframework.web.bind.annotation.RestController;

// import com.Movie.Ghibli.Data.GhibliRepository;


// @Controller
// public class homeController {

//     GhibliRepository gr;

//     homeController(GhibliRepository ghibliRepository){
//         this.gr = ghibliRepository;
//     }

//     @GetMapping("/login")
//     public String login() {    
//         return "login";
//     }


//     // @GetMapping("/")
//     // public String home(Model model) {
//     //     model.addAttribute("id",gr.findAll());
//     //     // model.addAttribute("title",gr.findAll());
//     //     // model.addAttribute("director",gr.findAll());
//     //     // model.addAttribute("release_date",gr.findAll());
//     //     // model.addAttribute("running_time",gr.findAll());
// 	//     return "home";
// 	// }

//     @GetMapping("/")
//     public String home(Model model) {
//         model.addAttribute("tot",gr.findById(1));
//         model.addAttribute("cas",gr.findById(2));
//         model.addAttribute("gra",gr.findById(3));
//         model.addAttribute("kik",gr.findById(4));
//         model.addAttribute("spi",gr.findById(5));
//         model.addAttribute("how",gr.findById(6));
// 	    return "home";
// 	}

    
//     @RequestMapping("/details")
//     public String details(Model model) {    
//         model.addAttribute("id",gr.findAll());
//         model.addAttribute("title",gr.findAll());
//         model.addAttribute("director",gr.findAll());
//         model.addAttribute("release_date",gr.findAll());
//         model.addAttribute("running_time",gr.findAll());
//         return "details";
//     }
 

// }