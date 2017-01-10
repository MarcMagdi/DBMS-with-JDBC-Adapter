package jdbc;

import java.sql.Connection;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;
import consolePortal.IjdbcAdaptor;
import consolePortal.JdbcAdaptor;

/**
 *
 * @author Michael.
 *
 */
public class DriverImp implements java.sql.Driver {
    /**
     * helper.
     */
	private IjdbcAdaptor jdbcAdapter;

	/**
	 * constructor of DriverImp.
	 */
	public DriverImp() {
		jdbcAdapter = new JdbcAdaptor();
	}

	@Override
	public final boolean acceptsURL(final String url) throws SQLException {
		return jdbcAdapter.acceptsURL(url);
	}

	@Override
	public final Connection connect(final String url,
			final Properties info) throws SQLException {
		if (this.acceptsURL(url)) {
			if (jdbcAdapter.connectToURL(info.get("path").toString(), url)) {
				return new ConnectionImp(info, jdbcAdapter);
			}
		}
		throw new SQLException();
	}

	@Override
	public final DriverPropertyInfo[] getPropertyInfo(
			final String url, final Properties info) throws SQLException {
		DriverPropertyInfo[] infoArray = new DriverPropertyInfo[3];
		infoArray[0] = new DriverPropertyInfo(
				"username", null);
		infoArray[1] = new DriverPropertyInfo(
				"password", null);
		infoArray[2] = new DriverPropertyInfo(
				"path", null);
		for (int i = 0; i < infoArray.length; i++) {
			infoArray[i].required = true;
		}
		return infoArray;
	}

	@Override
	public final int getMajorVersion() {
		throw new UnsupportedOperationException();
	}

	@Override
	public final int getMinorVersion() {
		throw new UnsupportedOperationException();
	}

	@Override
	public final Logger getParentLogger() throws SQLFeatureNotSupportedException {
		throw new UnsupportedOperationException();
	}

	@Override
	public final boolean jdbcCompliant() {
		throw new UnsupportedOperationException();
	}

}
