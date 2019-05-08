package com.capgemini.bankApp.controller;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.capgemini.bankapp.client.BankAccountClient;
import com.capgemini.bankapp.exception.BankAccountNotFoundException;
import com.capgemini.bankapp.exception.LowBalanceException;
import com.capgemini.bankapp.model.BankAccount;
import com.capgemini.bankapp.service.BankAccountService;
import com.capgemini.bankapp.service.impl.BankAccountServiceImpl;

@WebServlet(urlPatterns = { "*.do" }, loadOnStartup = 1)
public class BankAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BankAccountService bankService;
	static final Logger logger = Logger.getLogger(BankAccountController.class);

	public BankAccountController() {
		bankService = new BankAccountServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String path = request.getServletPath();

		if (path.equals("/Display_All_account_details.do")) {
			List<BankAccount> bankAccounts = bankService.findAllBankAccounts();
			RequestDispatcher dispatcher = request.getRequestDispatcher("Display_All_account_details.jsp");
			request.setAttribute("accounts", bankAccounts);
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");// default MIME type
		PrintWriter out = response.getWriter();

		String path = request.getServletPath();
		System.out.println(path);

		if (path.equals("/new_account.do")) {
			String accountHolderName = request.getParameter("accountHolderName");
			String accountType = request.getParameter("accountType");
			double accountBalance = Double.parseDouble(request.getParameter("accountBalance"));

			BankAccount account = new BankAccount(accountHolderName, accountType, accountBalance);
			if (bankService.addNewBankAccount(account)) {
				out.println("<h2>Bank Account is created successfully");
				out.println("<h2><a href='index.html'>[Home]</h2>");
				out.close();
			}
		}
		if (path.equals("/delete-account.do")) {
			long accountId = Long.parseLong(request.getParameter("accountId"));

			try {
				if (bankService.deleteBankAmount(accountId)) {
					out.println("<h2>Account deleted successfully");
					out.println("<h2><a href='index.html'>[Home]</h2>");

				}
			} catch (BankAccountNotFoundException e) {
				logger.error("Exception:", e);
			}
		}

		if (path.equals("/withdraw.do")) {
			long accountId = Long.parseLong(request.getParameter("accountId"));
			double amount = Double.parseDouble(request.getParameter("amount"));

			try {
				double balance = bankService.withdraw(accountId, amount);

				out.println("<h2>Amount withdraw successfully" + balance);
				out.println("<h2><a href='index.html'>[Home]</h2>");
			}

			catch (LowBalanceException | BankAccountNotFoundException e) {
				logger.error("Exception:", e);
			}

		}

		if (path.equals("/deposit.do")) {
			long accountId = Long.parseLong(request.getParameter("accountId"));
			double amount = Double.parseDouble(request.getParameter("amount"));
			try {
				double balance = bankService.deposit(accountId, amount);
				out.println("<h2>Amount deposit successfully" + balance);
				out.println("<h2><a href='index.html'>[Home]</h2>");

			} catch (BankAccountNotFoundException e) {
				logger.error("Exception:", e);
			}
		}

		if (path.equals("/fund_transfer.do")) {
			long fromAccount = Long.parseLong(request.getParameter("fromAccount"));
			long toAccount = Long.parseLong(request.getParameter("toAccount"));
			double amount = Double.parseDouble(request.getParameter("amount"));

			try {
				double balance = bankService.fundTransfer(fromAccount, toAccount, amount);
				out.println("<h2>Amount transfer successfully");
				out.println("<h2>balance= " + balance);
				out.println("<h2><a href='index.html'>[Home]</h2>");

			} catch (BankAccountNotFoundException | LowBalanceException e) {
				logger.error("Exception:", e);
			}
		}
		if (path.equals("/check_balance.do")) {
			long accountId = Long.parseLong(request.getParameter("accountId"));

			try {
				double blance = bankService.checkBalance(accountId);
				out.println(blance);
				out.println("<h2><a href='index.html'>[Home]</h2>");

			} catch (BankAccountNotFoundException e) {
				logger.error("Exception:", e);
			}
		}
		if (path.equals("/getDetails.do")) {
			long accountId = Long.parseLong(request.getParameter("accountId"));
			List<BankAccount> bankAccounts;
			try {
				bankAccounts = bankService.searchBankAccount(accountId);
				BankAccount accounts = bankAccounts.get(0);
				RequestDispatcher dispatcher = request.getRequestDispatcher("getDetails.jsp");
				request.setAttribute("account", accounts);
				dispatcher.forward(request, response);
			} catch (BankAccountNotFoundException e) {
				out.println("<h2>Account does not exist</h2>");
				out.close();
				logger.error("Exception:", e);
			}
		}

		if (path.equals("/search-account.do")) {
			long accountId = Long.parseLong(request.getParameter("accountId"));
			List<BankAccount> bankAccounts;
			try {
				bankAccounts = bankService.searchBankAccount(accountId);
				BankAccount accounts = bankAccounts.get(0);
				RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
				request.setAttribute("account", accounts);
				dispatcher.forward(request, response);
			} catch (BankAccountNotFoundException e) {
				out.println("<h2>Account not updated</h2>");
				out.close();
				logger.error("Exception:", e);
			}
		}
		if (path.equals("/update-bankaccount-details.do")) {
			long accountId1 = Long.parseLong(request.getParameter("accountId"));
			String accountHolderName = request.getParameter("accountHolderName");
			String accountType = request.getParameter("accountType");
			double accountBalance = Double.parseDouble(request.getParameter("accountBalance"));

			BankAccount account = new BankAccount(accountHolderName, accountType, accountBalance);
			
			if (bankService.UpdateBankAccountDetails(accountId1, accountHolderName, accountType)) {
				response.sendRedirect("Display_All_account_details.do");
			} else {
				out.println("<h2>Account not updated</h2>");
			}
		}
	}
}
