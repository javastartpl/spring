package pl.javastart.sec.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.javastart.sec.user.UserService;

@Controller
class ChangePasswordController {
    private final UserService userService;

    public ChangePasswordController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/change-password")
    String changePassword(@RequestParam String newPassword,
                          RedirectAttributes redirectAttributes) {
        userService.changeCurrentUserPassword(newPassword);
        return "redirect:/logout";
    }
}
