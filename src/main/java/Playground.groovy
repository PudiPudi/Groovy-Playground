import io.jsonwebtoken.*

import java.security.KeyFactory
import java.security.interfaces.RSAPublicKey
import java.security.spec.X509EncodedKeySpec;

//def publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2nnE9sj4GdXLW9OsIQT/tb6NNVTXAGO/vHsgjHQpKj9wB7P/5XcK8kZU+q0YJjz6coz6qnVUHGnKidvC4WsLbhhAfKAXglpCdwYskb6zsz/pkDnZfJuB9htkCmTa65L/ABMYyB0SGj704vBwq36g72DkaXejS2xyiGAFkEsaXwd9+52CM3hxgO36faPXwK0MILRRm6GYHwLltGiEoGpFX2wHASSisV0UM6nE1AzQwNJnjIUxz4MFk5Z8TzJbC7DZO5DV8HQ5Jx8VG9fou07UnhGG4yPRgHMeO+wTrivBPBCaEuOKFRbW5ke4BAPBOQ3/qQk+ojga8mIfK6HP55Ny/QIDAQAB";
//def jws = "eyJraWQiOiJMVURPVklDX0pXVCIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiJsdWRvIiwiaXNzIjoiaHR0cDpcL1wvbHVkb3ZpY21hcmNoYW5kLmJlIn0.eZ1pmnmdsHG_rdPgRmGV1jfNQv3NoHC-gKGUCBnVurGMQ_dptGYZ8yv9lqGlMn3DACaDnFk-L3fxi2nIH7jdEmzj_JW5HMAu7o3MFWy5nFIuMv6I68G-Z2lS2rLN6DCHhxTcRVl8dPzmKfbSsy3FR2epV82DDX5JWPhh2bmg8N_aIWdzqRByBtebTYn5i86aRB8L27BdBmywY0-bJMvx5ArLM3aUgZbePNESkCqASvKWQeW3S6j94hMh0Xfji4kXIk-zG1ks1cZuWeSsyjqntgvOuRcpvz6BWPvXDnKuLI4FS_WcUP1QPA5byJLXmLvzJpAe10AU26bkrxio5SyFYw";
def publicKey = "ay1WcXN4SlJVb190R1NuUl9LUVlaeVdDdFg4cndiNkhyZUpnTjF4ZURmaXpkSmJMT2p5dVBKUXQxVmZDUlVLb0J4YW5MbWFHM2NkN04tNkdVcnU4R3M5LWxudi1oV0pncnZnMVhWNGhVQ3NydU9oRGJjMTdoUlJjN2ItcE42LXZxNHJPdDR1WjkzV05lRkg4UjhZLVBNRTZmZTJSRHpDT0d1QTVjSTI4Qm1RdVBDaVlZeWl4Ml9Ca0t4dngwU1owUUpmcUI1UHFRZ0JvVjM0ZVd4R1BFMXlZaG11ZE9BUGpjRmU4S24yaS1JbUFUOEVXcmFXUTQ0QWRiOUlWMmtrVXVRRDl5d0FuMkZESWdnNzdwVG5mQ2NmMFQ4VjEyM1Y1QVV4bkxPeV91eTRJLXhxYlBGSUJ5Wm9NUEU2eVU5RDJxRFUtcmVUM1hPUmxTSkZyekg2VVB3";
def jws = "eyJraWQiOiJMVURPVklDX0pXVCIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiJsdWRvIiwiaXNzIjoiaHR0cDpcL1wvbHVkb3ZpY21hcmNoYW5kLmJlIn0.GyI-bWUlP6_sqGtggHwXKTLbJLfjfmR9x3d3tLsFHC5riYJpwIycsr4LxS4eKHi9U81uyJK01YJw6I0M6GA2Uc99NINRPy6JZvO96uYDe_ONKRJSHbmUYkpNGmZKuaj4d-0HWN2YKBEFbSP8sZ9Ej5nsHyvd71Eg0ke94gFtXWkcBYCiCowvZ_amPMcmIrPO8O2Ibmi_4-nnpOzLr4ZA11Sve_pA6VyA56dOGfKPHi_vq5uv4Wmfyq8VwXJrnSNPTeaVlSS0YsxokgB94hQH4kbjryzSvEMmWpzs9_7nNcpOW73V4Qw03-flzez-5bn3VKja55Qrv9Znrmy-vgz6Hw";

KeyFactory keyFactory = KeyFactory.getInstance("RSA");

byte[] publicBytes = Base64.getDecoder().decode(publicKey)
//byte[] publicBytes = publicKey.getBytes(StandardCharsets.US_ASCII);
X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
RSAPublicKey pubKey = (RSAPublicKey) keyFactory.generatePublic(keySpec);

String claims = Jwts.parser().setSigningKey(pubKey).parseClaimsJws(jws).getBody();

System.out.println("CLAIMS");
System.out.println("======================\n\n");
System.out.println(claims);
System.out.println("\n\n======================");
