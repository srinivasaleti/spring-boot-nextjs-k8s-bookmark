# Requirements:
 - NodeJS: https://nodejs.org/en
 - Java
 - Docker: https://www.docker.com/
 - Kubernetes: https://kubernetes.io/docs/setup/
 - Kind: https://kind.sigs.k8s.io/docs/user/quick-start/#installation

# App Up:
- **Create kind cluster:**  `make kind-up`
- **Apply K8s resources:**  `kubectl apply -f tools/k8s  --recursive`
- **View all K8s Resources & wait for all to be `Running`:** `kubectl get all` (Mostly take 2 mins)
- **Visit:** `localhost`

# App down:
- Delete k8s resources: `kubectl delete -f tools/k8s --recursive`
- Kind down: `make kind-down`