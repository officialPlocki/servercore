package de.plocki.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BackEnd{
  public static Map<UUID, UUID> tpRequest = new HashMap<>();
  public static Map<UUID, TeleportType> tpType = new HashMap<>();
}