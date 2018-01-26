package com.ashish.security.workflow.executor;

import java.util.List;

import com.ashish.security.workflow.SecurityCommand;

public class SecurityCommandExecutor {

	private boolean status = false;
	private List<SecurityCommand> command;

	public void setCommand(List<SecurityCommand> command) {
		this.command = command;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
