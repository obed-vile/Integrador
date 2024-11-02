package controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import model.Pedido;
import model.Usuario;
import service.PedidoService;
import service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	private final Logger logger= LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PedidoService pedidoService;
	
	// /usuario/registro
		@GetMapping("/registro")
		public String create() {
			return "usuario/registro";
		}
		
		@PostMapping("/save")
		public String save(Usuario usuario) {
			logger.info("Usuario registro: {}", usuario);
			usuarioService.save(usuario);			
			return "redirect:/";
		}
		
		@GetMapping("/login")
		public String login() {
			return "usuario/login";
		}
		
		@PostMapping("/acceder")
		public String acceder(Usuario usuario, HttpSession session) {
			logger.info("Accesos : {}", usuario);
			
			Optional<Usuario> user=usuarioService.findByEmail(usuario.getCorreo());
			//logger.info("Usuario de db: {}", user.get());
			
			if (user.isPresent()) {
				session.setAttribute("idusuario", user.get().getId());
				
				if (user.get().getRol().equals("admin")) {
					return "redirect:/administrador";
				}else {
					return "redirect:/";
				}
			}else {
				logger.info("Usuario no existe");
			}
			
			return "redirect:/";
		}
		
		@GetMapping("/compras")
		public String obtenerCompras(Model model, HttpSession session) {
			model.addAttribute("sesion", session.getAttribute("idusuario"));
			Usuario usuario= usuarioService.findById(  Integer.parseInt(session.getAttribute("idusuario").toString()) ).get();
			List<Pedido> pedidos= pedidoService.findByUsuario(usuario);
			logger.info("ordenes {}", pedidos);
			
			model.addAttribute("ordenes", pedidos);
			return "usuario/compras";
		}
		
		@GetMapping("/detalle/{id}")
		public String detalleCompra(@PathVariable Integer id, HttpSession session, Model model) {
			
			logger.info("Id de la orden: {}", id);
			Optional<Pedido> pedido=pedidoService.findById(id);
			
			model.addAttribute("detalles", pedido.get().getCarrito());
			//session
			model.addAttribute("sesion", session.getAttribute("idusuario"));
			return "usuario/detallecompra";
		}
		
		@GetMapping("/cerrar")
		public String cerrarSesion( HttpSession session ) {
			session.removeAttribute("idusuario");
			return "redirect:/";
		}

}
