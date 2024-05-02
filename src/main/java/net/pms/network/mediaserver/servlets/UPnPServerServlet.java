/*
 * This file is part of Universal Media Server, based on PS3 Media Server.
 *
 * This program is a free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; version 2 of the License only.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package net.pms.network.mediaserver.servlets;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import net.pms.network.HttpServletHelper;
import net.pms.network.mediaserver.jupnp.transport.impl.JdkHttpServletUpnpStream;
import org.jupnp.transport.Router;

/**
 * @author Surf@ceS
 */
@WebServlet(name = "UPnP HTTP SERVER", urlPatterns = {"/"}, displayName = "jUPnP Server Servlet")
public class UPnPServerServlet extends HttpServletHelper {

	private final Router router;

	public UPnPServerServlet(Router router) {
		this.router = router;
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (deny(req)) {
			return;
		}
		AsyncContext async = req.startAsync();
		router.received(new JdkHttpServletUpnpStream(router.getProtocolFactory(), async));
	}

}