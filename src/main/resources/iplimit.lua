local count = redis.call('incr', KEYS[1])
if count == 1 then
    redis.call('expire', KEYS[1], ARGV[1])
end

if count > tonumber(ARGV[2]) then
    return 1
end

return 0