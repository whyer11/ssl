package com.lyq.util1;

import java.util.UUID;

public final class GUIDUtil
{
	public static String newGuid()
	{
		UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        return randomUUIDString;
	}
}
