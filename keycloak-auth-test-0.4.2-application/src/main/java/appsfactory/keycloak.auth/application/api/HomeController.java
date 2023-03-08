package appsfactory.keycloak.auth.application.api;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home controller.
 */
@Controller
public class HomeController {

  private static final String SWAGGER_PATH = "/swagger-ui/api-docs.html";

  /**
   * Swagger UI path.
   */
  @Value("${springdoc.swagger-ui.path}")
  private String swaggerUiPath;

  /**
   * Redirect to swagger ui.
   *
   * @return redirect URI
   */
  @RequestMapping("/")
  public String home() {

    String toRedirect =
        StringUtils.isNotBlank(this.swaggerUiPath) ? this.swaggerUiPath : SWAGGER_PATH;

    return "redirect:" + toRedirect;
  }

}
