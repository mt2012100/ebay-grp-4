package edu.iiitb.ebay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import edu.iiitb.ebay.model.entity.SellerModel;
import edu.iiitb.ebay.model.page.CartPageModel;
import edu.iiitb.ebay.util.ConstantValues;

public class PaymentDAO extends BaseDAO {
	Logger logger = Logger.getLogger(PaymentDAO.class);

	public boolean validateDebitCard(int userId, String atmNumber,
			String pinNumber) {
		// TODO Auto-generated method stub
		boolean returnValue = false;
		String query = "SELECT * FROM bank WHERE userId=" + userId
				+ " AND atmNum='" + atmNumber + "' AND pinNum='" + pinNumber
				+ "'";
		ResultSet rs = readFromDB(query);
		try {
			while (rs.next()) {
				returnValue = true;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			returnValue = false;
			e.printStackTrace();
		}
		return returnValue;
	}

	public boolean validateCreditCard(int userId, String accountNumber,
			String password) {
		boolean returnValue = false;
		String query = "SELECT * FROM bank WHERE userId=" + userId
				+ " AND accountNum='" + accountNumber + "' AND password='"
				+ password + "'";
		ResultSet rs = readFromDB(query);
		try {
			while (rs.next()) {
				returnValue = true;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			returnValue = false;
			e.printStackTrace();
		}
		return returnValue;
	}

	public int getSellerId(int productId) {
		// TODO Auto-generated method stub
		String query = "SELECT sellerId FROM product WHERE productId="
				+ productId;
		int sellerId = 0;
		ResultSet rs = readFromDB(query);
		try {
			while (rs.next()) {
				sellerId = rs.getInt("sellerId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sellerId;
	}

	public SellerModel getSeller(int sellerId) {
		logger.info("Inside getSeller(int sellerId) method");
		SellerModel seller = null;
		String query = "SELECT * FROM seller WHERE sellerId=" + sellerId;
		logger.info("querying database: " + query);
		ResultSet rs = readFromDB(query);
		try {
			while (rs.next()) {
				seller = new SellerModel();
				seller.setSellerId(rs.getInt(1));
				seller.setDateOfRegistration(rs.getString(2));
				seller.setLocation(rs.getString(3));
				seller.setFeedbackScore(rs.getInt(4));
				seller.setPositivFeedBack(rs.getInt(5));
				seller.setUserId(rs.getInt(6));
				seller.setSla(rs.getInt(7));
				logger.info("Found a seller");
			}
		} catch (SQLException e) {
			logger.error("Error occurred:", e);
			e.printStackTrace();
		}
		return seller;
	}

	public int deduceMoney(int userId, float moneyToBeDeductedForThisCartItem) {
		// TODO Auto-generated method stub
		float balance = 0;
		String query = "SELECT balance FROM bank WHERE userId=" + userId;
		ResultSet rs = readFromDB(query);
		try {
			while (rs.next()) {
				balance = rs.getFloat("balance");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return ConstantValues.FAILURE;
		}
		if (balance < moneyToBeDeductedForThisCartItem)
			return ConstantValues.INSUFFICIENT_MONEY;
		balance = balance - moneyToBeDeductedForThisCartItem;
		query = "UPDATE bank SET balance=" + balance + " WHERE userId="
				+ userId;
		update(query);
		return ConstantValues.SUCCESS;
	}

	public int creditMoney(int userId, float moneyToBeCreditedIntoSeller) {
		// TODO Auto-generated method stub
		float balance = 0;
		String query = "SELECT balance FROM bank WHERE userId=" + userId;
		ResultSet rs = readFromDB(query);
		try {
			while (rs.next()) {
				balance = rs.getFloat("balance");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return ConstantValues.FAILURE;
		}
		balance = balance + moneyToBeCreditedIntoSeller;

		query = "UPDATE bank SET balance=" + balance + " WHERE userId="
				+ userId;
		update(query);
		return ConstantValues.SUCCESS;
	}

	public int updateCartItemStatus(int cartId, char c) {
		// TODO Auto-generated method stub
		String query = "UPDATE cart SET type='" + c + "'" + " WHERE cartId="
				+ cartId;
		update(query);
		return ConstantValues.SUCCESS;
	}

	public int insertIntoOrderTable(int userId, int sellerId, int productId,
			String string, int quantity) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO eBay.order(userId,sellerId,productId,currentStatus,statusUpdatedDate,orderPlacedDate,quantity) VALUES("
				+ userId
				+ ","
				+ sellerId
				+ ","
				+ productId
				+ ","
				+ string
				+ ",curdate(),curdate(),"
				+quantity
				+")";
		update(query);
		return ConstantValues.SUCCESS;
	}

	public static float getBalance(int userId) {
		float balance = 0;
		String query = "SELECT balance FROM bank WHERE userId=" + userId;
		ResultSet rs = readFromDB(query);
		try {
			while (rs.next()) {
				balance = rs.getFloat("balance");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return ConstantValues.FAILURE;
		}
		return balance;
	}

	public int decrementProductQuantity(int productId, int quantity) {
		// TODO Auto-generated method stub
		String query = "UPDATE product SET quantity=quantity-" + quantity
				+ " WHERE productId=" + productId;
		update(query);
		return 0;
	}

}
