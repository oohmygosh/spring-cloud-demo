package com.vipicu.demo.cloud.oauth.entity;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.IOException;
import java.util.Set;

public class CustomUserDeserializer extends JsonDeserializer<User> {

	private static final TypeReference<Set<SimpleGrantedAuthority>> SIMPLE_GRANTED_AUTHORITY_SET = new TypeReference<>() {
    };

	/**
	 * 读取json节点
	 * This method will create {@link User} object. It will ensure successful object
	 * creation even if password key is null in serialized json, because credentials
	 * may be removed from the {@link User} by invoking
	 * {@link User#eraseCredentials()}. In that case there won't be any password key
	 * in serialized json.
	 *
	 * @param jsonNode json节点
	 * @param field    场
	 * @return {@link JsonNode}
	 */
	private JsonNode readJsonNode(JsonNode jsonNode, String field) {
		return jsonNode.has(field) ? jsonNode.get(field) : MissingNode.getInstance();
	}

	@Override
	public User deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException {
		ObjectMapper mapper = (ObjectMapper) jp.getCodec();
		JsonNode jsonNode = mapper.readTree(jp);
		Set<? extends GrantedAuthority> authorities = mapper.convertValue(jsonNode.get("authorities"),
				SIMPLE_GRANTED_AUTHORITY_SET);
		JsonNode passwordNode = readJsonNode(jsonNode, "password");
		String username = readJsonNode(jsonNode, "username").asText();
		String password = passwordNode.asText("");
		boolean enabled = readJsonNode(jsonNode, "status").asBoolean();
		boolean accountNonExpired = readJsonNode(jsonNode, "accountNonExpired").asBoolean();
		boolean credentialsNonExpired = readJsonNode(jsonNode, "credentialsNonExpired").asBoolean();
		boolean accountNonLocked = readJsonNode(jsonNode, "accountNonLocked").asBoolean();
		User result = new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
				authorities);
		if (passwordNode.asText(null) == null) {
			result.eraseCredentials();
		}
		return result;
	}
}
